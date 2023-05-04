package inf112.skeleton.app;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class Animation {
    
    private Array<TextureRegion> frames;
    private float maxFrameTime;
    private float currentFrameTime;
    private int frameCount;
    private int frame;

    public Animation(TextureRegion region, int frameCount, float cycleTime) {
        frames = new Array<TextureRegion>();
        int frameWidth = region.getRegionWidth() / frameCount;
        
        for (int i = 0; i < frameCount; i++) {
            frames.add(new TextureRegion(region, i * frameWidth, 0, frameWidth, region.getRegionHeight()));
        }
        this.frameCount = frameCount;
        maxFrameTime = cycleTime / frameCount;
        frame = 0;
    }
    /**
     * updates the frame 
     * @param dt delta time parameter decides how often the frame changes
     */
    public void update(float dt) {
        currentFrameTime += dt;
        if (currentFrameTime > maxFrameTime) {
            frame ++;
            currentFrameTime = 0;
        }
        if (frame >= frameCount) {
            frame = 0;
        }
    }
    /**
     * @returns current frame.
     */
    public TextureRegion getFrame() {
        return frames.get(frame);
    }
    /**
     * sets how long it takes for a cycle of animation.
     * @param time 
     */
    public void setCycleTime(float time) {
        maxFrameTime = time / frameCount;
    }
    /**
     * @return maximum frame time.
     */
    public float getMaxFrameTime() {
        return maxFrameTime;
    }


}
