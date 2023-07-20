public class LockerDriver
{
    public static void main(String[] args)
    {
        Locker locker = new Locker(1337);
        System.out.println(locker);

        // Test getCombination and nextCombination
        System.out.println("Current Combination: " +
                locker.getCombination());    // A
        locker.nextCombination();                       // B
        locker.nextCombination();                       // C
        System.out.println("Current Combination: " +
                locker.getCombination());               // C
        locker.nextCombination();                       // D
        locker.nextCombination();                       // E
        locker.nextCombination();                       // A
        System.out.println("Current Combination: " +
                locker.getCombination());               // A

        System.out.println();

        // Test getContents
        locker.addItem("Water Bottle");
        locker.addItem("Math Book");
        System.out.println("Contents: " +
                locker.getContents());                  // Math Book, Water Bottle
        locker.addItem("Picture of Mr. Hubbard");
        locker.removeItem("Math Book");
        locker.removeItem("Picture");                   // Doesn't exist
        System.out.println("Contents: " +
                locker.getContents());                  // Picture of Mr. Hubbard, Water Bottle
        locker.removeItem("Water Bottle");

        System.out.println();

        System.out.println(locker);
    }
}
