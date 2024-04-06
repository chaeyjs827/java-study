package pattern.adapter.image;

// 내부 시스템에서 사용하는 표준 이미지 처리 인터페이스
public interface ImageProcessor {
    void processImage(String fileName);
}
