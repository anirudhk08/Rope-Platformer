package test.components;

import components.Platform;
import menus.GameLevelConstants;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.*;

/**
 * Tests Platform class
 * Created by aubhrosengupta on 5/28/17.
 */
public class PlatformTest {


    /**
     * tests created platforms for each level
     * @throws Exception something wrong happened
     */
    @Test
    public void createPlatforms() throws Exception {
        ArrayList<Platform> platforms = Platform.createPlatforms(GameLevelConstants.LEVEL_INTRO);
        assertEquals(platforms.size(), 2);

        platforms = Platform.createPlatforms(GameLevelConstants.LEVEL_COOL);
        assertEquals(platforms.size(), 3);

        platforms = Platform.createPlatforms(GameLevelConstants.LEVEL_GOOD);
        assertEquals(platforms.size(), 2);

        platforms = Platform.createPlatforms(GameLevelConstants.LEVEL_SCARY);
        assertEquals(platforms.size(), 3);

        platforms = Platform.createPlatforms(GameLevelConstants.LEVEL_UNBEARABLE);
        assertEquals(platforms.size(), 4);

        platforms = Platform.createPlatforms(GameLevelConstants.LEVEL_FINAL);
        assertEquals(platforms.size(), 5);

    }

}