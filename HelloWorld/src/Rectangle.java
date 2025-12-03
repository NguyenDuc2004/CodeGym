public class Rectangle {
    float width;
    float height;

    public Rectangle(float height, float width) {
        this.height = height;
        this.width = width;
    }

    public float getWidth() {
        return width;
    }


    public float getHeight() {
        return height;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float area(){
        return width + height;
    }
}
