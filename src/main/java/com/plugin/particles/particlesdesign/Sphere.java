package com.plugin.particles.particlesdesign;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class Sphere extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void CreateShape(PlayerInteractEvent e) {
        if (e.getAction() == Action.LEFT_CLICK_AIR) {
            Location loc = e.getPlayer().getLocation();




            new BukkitRunnable() {
                double theta;


                @Override
                public void run() {
                    theta += Math.PI/8;
                    for (double phi = 0; phi < Math.PI*2; phi += Math.PI/8) {
                       double r = 1.5;
                       double x = r*Math.sin(phi) * Math.cos(theta);
                       double y = r*Math.cos(phi);
                       double z = r*Math.sin(phi) * Math.sin(theta);
                       loc.add(x, y, z);
                       e.getPlayer().spawnParticle(Particle.FLAME, loc, 0, 0, 0, 0, 1);
                       loc.subtract(x, y,z);
                    }
                    if (theta > 2*Math.PI) cancel();
                }

            }.runTaskTimer(this, 0, 1L);


            }


        }

    }

