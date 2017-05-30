package test.components;

import components.Platform;
import menus.GameLevelConstants;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.*;

/**
 * Test class to validate the methods and functionality of Platform class
 */
public class PlatformTest {
    /**
     * Test that platforms are created properly for Intro game level
     * @throws Exception - exception if there's an error with creation
     */
    @Test
    public void createPlatformsForIntroLevel() throws Exception {
        ArrayList<Platform> platforms = Platform.createPlatforms(GameLevelConstants.LEVEL_INTRO);
        assertEquals(platforms.size(), 2);
    }

    /**
     * Test that platforms are created properly for Cool game level
     * @throws Exception - exception if there's an error with creation
     */
    @Test
    public void createPlatformsForCoolLevel() throws Exception {
        ArrayList<Platform> platforms = Platform.createPlatforms(GameLevelConstants.LEVEL_COOL);
        assertEquals(platforms.size(), 3);
    }

    /**
     * Test that platforms are created properly for Good game level
     * @throws Exception - exception if there's an error with creation
     */
    @Test
    public void createPlatformsForGoodLevel() throws Exception {
        ArrayList<Platform> platforms = Platform.createPlatforms(GameLevelConstants.LEVEL_GOOD);
        assertEquals(platforms.size(), 2);
    }

    /**
     * Test that platforms are created properly for Scary game level
     * @throws Exception - exception if there's an error with creation
     */
    @Test
    public void createPlatformsForScaryLevel() throws Exception {
        ArrayList<Platform> platforms = Platform.createPlatforms(GameLevelConstants.LEVEL_SCARY);
        assertEquals(platforms.size(), 3);
    }

    /**
     * Test that platforms are created properly for Unbearable game level
     * @throws Exception - exception if there's an error with creation
     */
    @Test
    public void createPlatformsForUnbearbleLevel() throws Exception {
        ArrayList<Platform> platforms = Platform.createPlatforms(GameLevelConstants.LEVEL_UNBEARABLE);
        assertEquals(platforms.size(), 4);
    }

    /**
     * Test that platforms are created properly for Final game level
     * @throws Exception - exception if there's an error with creation
     */
    @Test
    public void createPlatformsForFinalLevel() throws Exception {
        ArrayList<Platform> platforms = Platform.createPlatforms(GameLevelConstants.LEVEL_FINAL);
        assertEquals(platforms.size(), 5);
    }

}