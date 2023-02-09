package guru.qa.tests;

import org.junit.jupiter.api.Test;

public class VideoOnLandingPageTest extends TestBase {

    @Test
    public void checkVideoOnLandingPage() {
        landingPage.clickWatchVideoButton();
        generalActions.checkVisibility(modalPage.videoModalWindow);
        generalActions.checkVisibility(modalPage.closeModalButton);

        generalActions.checkThatElementContains(
                modalPage.video,
                "https://www.youtube.com/embed/", "autoplay=1");
        generalActions.switchToFrame(modalPage.video);
        modalPage.checkVideoIsPlaying();
    }
}
