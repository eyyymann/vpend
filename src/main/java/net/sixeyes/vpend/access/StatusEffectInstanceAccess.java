package net.sixeyes.vpend.access;

/* EXPLANATION
* -this interface provides the setPaused method
* -that is used to change the paused field of
* -in the StatusEffectInstanceMixin
* */

public interface StatusEffectInstanceAccess {

    void setPaused(boolean b);

    boolean getPaused();
}
