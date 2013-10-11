package org.nathantehbeast.scripts.aiominer;

import org.nathantehbeast.api.framework.Script;
import org.nathantehbeast.api.framework.methods.Task;
import org.nathantehbeast.api.framework.utils.SkillData;
import org.nathantehbeast.scripts.aiominer.jobs.Mining;
import org.powerbot.script.Manifest;
import org.powerbot.script.wrappers.Tile;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan
 * Date: 7/25/13
 * Time: 8:07 PM
 * To change this template use File | Settings | File Templates.
 */

@Manifest(
        authors = "Nathan L",
        name = "Nathan's AIO Miner",
        description = "Currently being rewritten.",
        version = 1.2,
        hidden = true
)

public class v5Miner extends Script {

    private SkillData sd;

    @Override
    public boolean setup() {
        provide(new Mining(ctx));
        return true;
    }

    @Override
    public void loop() {

    }

    @Override
    public void exit() {
    }

    @Override
    public void onRepaint(Graphics2D g) {
        g.drawString("Current Node: "+currentNode, 15, 15);
    }
}
