package SlicesImageRecolorMethod;

import Abstractions.IImageRecolorMethod;
import SlicesMethod.SlicesImageRecolorMethod;
import junit.framework.TestCase;

public class TestSlicesImageRecolorMethod extends TestCase {

    public void testSlicesImageRecolorMethodOutput() {
        IImageRecolorMethod method = new SlicesImageRecolorMethod(1);
        method.recolorImage();
    }
}
