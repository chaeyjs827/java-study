package pattern.adapter.image;

public class ImageProcessMain {
    public static void main(String[] args) {
        // 외부 라이브러리 인스턴스 생성
        ExternalImageProcessor externalProcessor = new ExternalImageProcessor();

        // Adapter를 통해 외부 라이브러리를 내부 시스템에 통합
        ImageProcessor adapter = new ImageProcessorAdapter(externalProcessor);

        // 내부 시스템에서 표준 인터페이스를 통해 이미지 처리
        adapter.processImage("sample.jpg");
    }
}
