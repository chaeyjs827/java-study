package pattern.adapter.image;

// 서드파티 이미지 처리 라이브러리
public class ExternalImageProcessor {
    public void loadImage(String file) {
        System.out.println("External library: Loading image " + file);
    }

    public void manipulateImage() {
        System.out.println("External library: Manipulating image");
    }

    public void saveImage() {
        System.out.println("External library: Saving image");
    }
}

