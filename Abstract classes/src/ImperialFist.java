public class ImperialFist extends SpaceMarine{
    public ImperialFist(String name) {
        super(name);
    }

    public ImperialFist(String name, boolean primaris) {
        super(name, primaris);
    }

    @Override
    public void chapterPrimarch() {
        System.out.println(getName()+" is a proud son of Dorn!");
    }

    @Override
    public void praiseTheEmperor() {
        System.out.println(getName()+" shouts 'PRAISE THE EMPRAH'");
    }
}
