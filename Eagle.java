import java.net.SocketImpl;

public class Eagle extends Bird implements Fly {

    private boolean flying;
    private int altitude;

    public Eagle(String name) {
        super(name);
        this.flying = false;
        this.altitude = 0;
    }

    public int getAltitude() {
        return altitude;
    }

    public boolean isFlying() {
        return flying;
    }

    @Override
    public String sing() {
        return "Screech!";
    }

    @Override
    public void takeOff() {
        if (!this.flying && this.altitude == 0) {
            this.flying = true;
            System.out.printf(this.getName() + " takes off in the sky.%n");
        }
    }


    @Override
    public int ascend(int meters) {
        if (this.flying) {
            this.altitude = Math.max(this.altitude + meters, 120);
            System.out.printf(this.getName() + " flies upward, altitude : " + this.altitude + "%n");
        }
        return this.altitude;
    }

    @Override
    public void glide() {
        if (this.flying && this.altitude != 0) {
            this.flying = true;
            System.out.printf("It glides into the air. %n");
        }
    }

    @Override
    public int descend(int meters) {
        if (this.flying) {
            this.altitude = Math.min(this.altitude - meters, 140);
            System.out.printf(this.getName() + " flies downward, altitude : " + this.altitude + "%n");
        }
        return this.altitude;
    }

    @Override
    public void land() {
        if (this.flying && this.altitude == 0) {
            System.out.printf("%s is too high, it can't lands.%n", this.getName());
        } else {
            System.out.printf("%s lands on the ground.%n", this.getName());
        }
    }

}
