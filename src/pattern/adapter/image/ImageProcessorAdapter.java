package pattern.adapter.image;

// Adapter 클래스
public class ImageProcessorAdapter implements ImageProcessor {
    private ExternalImageProcessor externalProcessor;

    public ImageProcessorAdapter(ExternalImageProcessor externalProcessor) {
        this.externalProcessor = externalProcessor;
    }

    @Override
    public void processImage(String fileName) {
        // 외부 라이브러리를 내부 시스템에 통합
        externalProcessor.loadImage(fileName);
        externalProcessor.manipulateImage();
        externalProcessor.saveImage();
    }
}
