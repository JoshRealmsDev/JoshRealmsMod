package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.Achievement;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level=AdminLevel.SUPER, source=SourceType.ONLY_IN_GAME)
@CommandParameters(description="get all Achievements", usage="/<command>")
public class Command_achievement extends TFM_Command
{
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
        {
            playerMsg(null);
            sender_p.awardAchievement(Achievement.ACQUIRE_IRON);
            sender_p.awardAchievement(Achievement.BAKE_CAKE);
            sender_p.awardAchievement(Achievement.BOOKCASE);
            sender_p.awardAchievement(Achievement.BREED_COW);
            sender_p.awardAchievement(Achievement.BREW_POTION);
            sender_p.awardAchievement(Achievement.BUILD_BETTER_PICKAXE);
            sender_p.awardAchievement(Achievement.BUILD_FURNACE);
            sender_p.awardAchievement(Achievement.BUILD_HOE);
            sender_p.awardAchievement(Achievement.BUILD_PICKAXE);
            sender_p.awardAchievement(Achievement.BUILD_SWORD);
            sender_p.awardAchievement(Achievement.BUILD_WORKBENCH);
            sender_p.awardAchievement(Achievement.COOK_FISH);
            sender_p.awardAchievement(Achievement.DIAMONDS_TO_YOU);
            sender_p.awardAchievement(Achievement.ENCHANTMENTS);
            sender_p.awardAchievement(Achievement.END_PORTAL);
            sender_p.awardAchievement(Achievement.EXPLORE_ALL_BIOMES);
            sender_p.awardAchievement(Achievement.FLY_PIG);
            sender_p.awardAchievement(Achievement.FULL_BEACON);
            sender_p.awardAchievement(Achievement.GET_BLAZE_ROD);
            sender_p.awardAchievement(Achievement.GET_DIAMONDS);
            sender_p.awardAchievement(Achievement.GHAST_RETURN);
            sender_p.awardAchievement(Achievement.KILL_COW);
            sender_p.awardAchievement(Achievement.KILL_ENEMY);
            sender_p.awardAchievement(Achievement.KILL_WITHER);
            sender_p.awardAchievement(Achievement.MAKE_BREAD);
            sender_p.awardAchievement(Achievement.MINE_WOOD);
            sender_p.awardAchievement(Achievement.NETHER_PORTAL);
            sender_p.awardAchievement(Achievement.ON_A_RAIL);
            sender_p.awardAchievement(Achievement.OPEN_INVENTORY);
            sender_p.awardAchievement(Achievement.OVERKILL);
            sender_p.awardAchievement(Achievement.SNIPE_SKELETON);
            sender_p.awardAchievement(Achievement.SPAWN_WITHER);
            sender_p.awardAchievement(Achievement.THE_END);
        return true;
    }
}