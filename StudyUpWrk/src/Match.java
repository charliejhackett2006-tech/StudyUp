public class Match {

    private Student student;
    private int sharedModules;
    private int overlappingSlots;

    public Match(Student student, int sharedModules, int overlappingSlots) {
        this.student = student;
        this.sharedModules = sharedModules;
        this.overlappingSlots = overlappingSlots;
    }

    public Student getStudent() { return student; }
    public int getSharedModules() { return sharedModules; }
    public int getOverlappingSlots() { return overlappingSlots; }

    public boolean isBetterThan(Match other) {
        if (sharedModules != other.sharedModules) {
            return sharedModules > other.sharedModules;
        }
        return overlappingSlots > other.overlappingSlots;
    }

    @Override
    public String toString() {
        return student + "Matching modules modules: " + sharedModules
                + "Matching time slots: " + overlappingSlots;
    }
}