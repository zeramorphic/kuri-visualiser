package com.thirds.kuri;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.thirds.kuri.position.ProceduralPosition;
import com.thirds.kuri.unit.AbsoluteTime;
import com.thirds.kuri.unit.Length;
import com.thirds.kuri.unit.Mass;

/**
 * Represents a body in space. This may be a planet, asteroid, star, spaceship etc.
 */
public class Body {
    private final Color colour;
    private final Mass mass;
    private final Length radius;
    private final ProceduralPosition position;

    public Body(Color colour, Mass mass, Length radius, ProceduralPosition position) {
        this.colour = colour;
        this.mass = mass;
        this.radius = radius;
        this.position = position;
    }

    public Mass getMass() {
        return mass;
    }

    public Length getRadius() {
        return radius;
    }

    public ProceduralPosition getPosition() {
        return position;
    }

    public void render(ShapeRenderer sr, float viewZoom, AbsoluteTime time) {
        Vector2 screenPos = position.getPositionAtTime(time.getSinceFirstColony()).asScreenPosition();
        float radius = getRadius().asAstronomicalUnits().floatValue();

        // Make sure that the apparent radius is no smaller than ~5 px.
        final float MIN_SIZE = 5f;
        float screenRadius = radius * viewZoom;
        screenRadius += Math.log(1d + Math.exp(screenRadius - MIN_SIZE)) + MIN_SIZE;
        radius = screenRadius / viewZoom;

        sr.setColor(colour);
        sr.circle(screenPos.x, screenPos.y, radius, (int) (screenRadius * 5));
    }
}
