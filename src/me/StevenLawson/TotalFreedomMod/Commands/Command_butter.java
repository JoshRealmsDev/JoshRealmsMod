package me.StevenLawson.TotalFreedomMod.Commands;

import java.util.Random;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.Achievement;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.BOTH)
@CommandParameters(description = "Skydoesminecraft's Command.", usage = "/<command> -a")
public class Command_butter extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        ItemStack BS = new ItemStack(Material.GOLD_INGOT);
        ItemMeta BSM = BS.getItemMeta();
        BSM.setDisplayName((new StringBuilder()).append(ChatColor.GOLD).append("Butter").append(ChatColor.YELLOW).append("Slap").toString());
        BSM.addEnchant(Enchantment.KNOCKBACK, 20, true);
        BSM.addEnchant(Enchantment.FIRE_ASPECT, 10, true);
        BS.setItemMeta(BSM);
        StringBuilder output = new StringBuilder();
        Random randomGenerator = new Random();

        String[] words = TotalFreedomMod.BUTTER_LYRICS.split(" ");
        for (String word : words)
        {
            String color_code = Integer.toHexString(1 + randomGenerator.nextInt(14));
            output.append(ChatColor.COLOR_CHAR).append(color_code).append(word).append(" ");
        }
        if (args.length != 1)
        {
            ItemStack heldItem = new ItemStack(BS);
            sender_p.getInventory().setItem(sender_p.getInventory().firstEmpty(), heldItem);
        }
        else if (args.length == 1)
        {
            if (args[0].equalsIgnoreCase("-a"))
            {
                for (Player player : server.getOnlinePlayers())
                {
                    ItemStack heldItem = new ItemStack(BS);
                    player.getInventory().setItem(player.getInventory().firstEmpty(), heldItem);
                    player.awardAchievement(Achievement.MINE_WOOD);
                    player.awardAchievement(Achievement.BUILD_WORKBENCH);
                    player.awardAchievement(Achievement.BUILD_PICKAXE);
                    player.awardAchievement(Achievement.ACQUIRE_IRON);
                }
            TFM_Util.bcastMsg(output.toString());
            return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
        return true;
    }
}