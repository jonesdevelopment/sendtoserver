/*
 * Copyright (C) 2024 jones
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package xyz.jonesdev.s2s.bukkit;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static xyz.jonesdev.s2s.bukkit.S2SBukkitPlugin.CHANNEL;

public final class S2SCommandBukkit implements CommandExecutor {

  @Override
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    if (strings.length <= 1) {
      commandSender.sendMessage("§cИспользование: /s2s <сервер> <игрока>");
      return false;
    }

    final String server = strings[0];
    final Player player = Bukkit.getPlayer(strings[1]);

    if (player == null) {
      commandSender.sendMessage("§cНе удалось найти игрока.");
      return false;
    }

    final ByteArrayDataOutput out = ByteStreams.newDataOutput();
    out.writeUTF("Connect");
    out.writeUTF(server);

    player.sendPluginMessage(S2SBukkitPlugin.instance, CHANNEL, out.toByteArray());
    return false;
  }
}
