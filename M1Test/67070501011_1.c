#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int width;
    int height;
    int bitDepth;
    unsigned char header[54];
    unsigned char ***data;
} BMPImage;

unsigned char*** allocateImage(int height, int width) {
    unsigned char ***image = malloc(height * sizeof(unsigned char**));
    for (int i = 0; i < height; i++) {
        image[i] = malloc(width * sizeof(unsigned char*));
        for (int j = 0; j < width; j++) {
            image[i][j] = malloc(3 * sizeof(unsigned char));
        }
    }
    return image;
}

void freeImage(unsigned char ***image, int height, int width) {
    for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
            free(image[i][j]);
        }
        free(image[i]);
    }
    free(image);
}

BMPImage readBMP(const char *filename) {
    BMPImage img;
    FILE *fIn = fopen(filename, "rb");
    if (fIn == NULL) {
        printf("Error: File not found.\n");
        exit(1);
    }

    fread(img.header, sizeof(unsigned char), 54, fIn);

    img.width = *(int*)&img.header[18];
    img.height = *(int*)&img.header[22];
    img.bitDepth = *(int*)&img.header[28];

    printf("Reading Image: %s\n", filename);
    printf("Width: %d, Height: %d, Bit Depth: %d\n", img.width, img.height, img.bitDepth);

    int row_padded = (img.width * 3 + 3) & (~3);
    unsigned char row[row_padded];

    img.data = allocateImage(img.height, img.width);

    for (int i = 0; i < img.height; i++) {
        fread(row, sizeof(unsigned char), row_padded, fIn);
        for (int j = 0; j < img.width; j++) {
            img.data[i][j][2] = row[j * 3];
            img.data[i][j][1] = row[j * 3 + 1];
            img.data[i][j][0] = row[j * 3 + 2];
        }
    }

    fclose(fIn);
    return img;
}

void writeBMP(const char *filename, BMPImage img) {
    FILE *fOut = fopen(filename, "wb");
    if (fOut == NULL) {
        printf("Error: Unable to create file.\n");
        exit(1);
    }

    fwrite(img.header, sizeof(unsigned char), 54, fOut);

    int row_padded = (img.width * 3 + 3) & (~3);
    unsigned char row[row_padded];

    for (int i = 0; i < img.height; i++) {
        for (int j = 0; j < img.width; j++) {
            row[j * 3] = img.data[i][j][2];     // Blue
            row[j * 3 + 1] = img.data[i][j][1]; // Green
            row[j * 3 + 2] = img.data[i][j][0]; // Red
        }
        fwrite(row, sizeof(unsigned char), row_padded, fOut);
    }

    fclose(fOut);
    printf("Image saved: %s\n", filename);
}

void color(BMPImage img, int x0, int y0, int x1, int y1, int r, int g, int b){
    BMPImage temp = img;
    temp.data = allocateImage(img.height, img.width);
    for(int i = x0; i <= x1; i++){
        img.data[i][y0][0] = r;
        img.data[i][y0][1] = g;
        img.data[i][y0][2] = b;
    }
    for(int i = x0; i <= x1; i++){
        img.data[i][y1][0] = r;
        img.data[i][y1][1] = g;
        img.data[i][y1][2] = b;
    }

    for(int i = y0; i <= y1; i++){
        img.data[x0][i][0] = r;
        img.data[x0][i][1] = g;
        img.data[x0][i][2] = b;
    }
    for(int i = y0; i <= y1; i++){
        img.data[x1][i][0] = r;
        img.data[x1][i][1] = g;
        img.data[x1][i][2] = b;
    }
    // for(int i = x0; i <= x1; i++){
    //     for(int j = 0; j <= 100; j++){
    //             img.data[i][j][0] = r;
    //             img.data[i][j][1] = g;
    //             img.data[i][j][2] = b;
    //     }
    // }
}


int main() {

    BMPImage img = readBMP("trump.bmp");

    int x0, y0, x1, y1, r, g, b;
    scanf("%d %d %d %d", &x0, &y0, &x1, &y1);
    scanf("%d %d %d", &r, &g, &b);

    color(img, x0, y0, x1, y1, r, g, b);

    writeBMP("output.bmp", img);
    freeImage(img.data, img.height, img.width);
    return 0;
}
