package org.nathantehbeast.scripts.winegrabber.jobs;

import org.nathantehbeast.api.framework.Node;
import org.nathantehbeast.api.framework.context.Context;
import org.nathantehbeast.api.framework.methods.Lodestone;
import org.powerbot.script.util.Timer;
import org.powerbot.script.wrappers.Tile;
import org.powerbot.script.wrappers.TilePath;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan
 * Date: 10/10/13
 * Time: 11:19 PM
 * To change this template use File | Settings | File Templates.
 */

@SuppressWarnings("ALL")
public class TraverseTemple extends Node {

    private final TilePath PATH;

    public TraverseTemple(Context ctx) {
        super(ctx);
        this.PATH = new TilePath(ctx, new Tile[]{new Tile(2965, 3404, 0), new Tile(2965, 3409, 0),
                new Tile(2963, 3414, 0), new Tile(2959, 3417, 0),
                new Tile(2954, 3419, 0), new Tile(2951, 3423, 0),
                new Tile(2948, 3427, 0), new Tile(2947, 3432, 0),
                new Tile(2946, 3437, 0), new Tile(2946, 3442, 0),
                new Tile(2946, 3447, 0), new Tile(2946, 3452, 0),
                new Tile(2948, 3457, 0), new Tile(2952, 3460, 0),
                new Tile(2955, 3464, 0), new Tile(2956, 3469, 0),
                new Tile(2957, 3474, 0), new Tile(2952, 3475, 0),
                new Tile(2950, 3473, 0) });
    }

    @Override
    public int priority() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean activate() {
        return !ctx.players.local().isInCombat() && !ctx.inventory.isFull() && ctx.players.local().getLocation().distanceTo(new Tile(2952, 3474, 0)) > 2  && !ctx.bank.isOpen() && ctx.inventory.contains(563);
    }

    @Override
    public void execute() {
        if (ctx.players.local().getLocation().distanceTo(new Tile(2945, 3367, 0)) <= 8) {
            ctx.lodestone.teleportTo(Lodestone.Location.FALADOR, 1);
            sleep(2000);
            final Timer t = new Timer(10000);
            while (ctx.players.local().getAnimation() != -1 && t.isRunning()) {
                sleep(800);
            }
        } else {
            if (ctx.players.local().getLocation().distanceTo(new Tile(2952, 3474, 0)) <= 3) {
                ctx.movement.stepTowards(new Tile(2952, 3474, 0));
            } else {
                PATH.traverse();
            }
        }
    }
}