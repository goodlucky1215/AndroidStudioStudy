package com.example.geloggame;

public class Sprite {
    protected int x, y; // 현재좌표
    protected int width, height; // 화언의 크기
    protected int dx, dy; // 속도
    private Bitmap bitmap;
    protected int id;
    private RectF rect;

    // 생성자
// 이미지
// 이미지 리소스 아이디
// 사각형 ， 충돌 검사에 사용한다.
    public Sprite(Context context, int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
        bitmap = BitmapFactory.decodeResource(context.getResources(), id);
        width = bitmap.getWidth();
        height = bitmap.getHeight();
        rect = new RectF();
    }

    public int getWidth() {
        return bitmap.getWidth();
    }

    public int getHeight() {
        return bitmap.getHeight();
    }

    public void draw(Canvas g, Paint p) {
        g.drawBitmap(bitmap, x, y, p);
    }

    public void move() {
        x += dx;
        y += dy;
        rect.left = x;
        rect.right = x + width;
        rect.top = y;
        rect.bottom = y + height;
    }

    public void setDx(int dx) { this .dx = dx ; }
    public void setDy(int dy) { this.dy = dy ; }
    public int getDx() { return dx ;}
    public int getDy() { return dy ;}
    public int getX() { return x;}
    public int gety() { return y ;}
    public RectF getRect () { return rect;}
// 다른 스프라이트와의 충돌 여부를 계산한다 . 충돌이면 true를 반환한다
    public boolean checkCollision(Sprite other) {
        return RectF.intersects( this.getRect() , other.getRect());
    }
// 충돌을처리한다 .
    public void handleCollision(Sprite other) {

    }

}