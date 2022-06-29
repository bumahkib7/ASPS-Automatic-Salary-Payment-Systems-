//create an animation component
import React from 'react';
import { useSpring, animated } from 'react-spring';
import { useGesture } from 'react-use-gesture';


const Animations = () => {
    const [{ xy }, set] = useSpring(() => ({ xy: [0, 0] }));
    const bind = useGesture(({ down, delta: [xDelta, yDelta] }) => {
        set({ xy: down ? [xDelta, yDelta] : [0, 0] });
    })();
    return (
        <animated.div
        {...bind()}
        style={{
            transform: xy.interpolate((x, y) => `translate3d(${x}px, ${y}px, 0)`),
        }}
        />
    );
}