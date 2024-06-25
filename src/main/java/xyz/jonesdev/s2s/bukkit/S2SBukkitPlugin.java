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

import org.bukkit.plugin.java.JavaPlugin;

public final class S2SBukkitPlugin extends JavaPlugin {
  public static S2SBukkitPlugin instance;
  public static final String CHANNEL = "BungeeCord"; // works under Velocity, too

  @Override
  public void onEnable() {
    instance = this;
    getServer().getMessenger().registerOutgoingPluginChannel(this, CHANNEL);
    getCommand("s2s").setExecutor(new S2SCommandBukkit());
  }

  @Override
  public void onDisable() {
    getServer().getMessenger().unregisterOutgoingPluginChannel(this, CHANNEL);
  }
}
