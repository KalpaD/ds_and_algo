/**
 * This class is a demonestration of the BitMask to identify *nix line permission model
 * For a real application the the system will provide the bit mask which need to identify the permission
 * for the demonestration purpose we will use a local constant.
 */
public class Bitmask {

    private final int BIT_MASK = 0b0000_0000_0000_0111;

    private void printPermission(short permissions) {

        //System.out.println(Integer.toBinaryString(permissions));

        int user_permission =  permissions & BIT_MASK;
        int group_permission = permissions >> 3 & BIT_MASK;
        int owner_permission = permissions >> 6 & BIT_MASK;

        //System.out.println(Integer.toBinaryString(owner_permission));

        String user_perm_string = interpretPermission(user_permission);
        String group_perm_string = interpretPermission(group_permission);
        String owner_perm_string = interpretPermission(owner_permission);

        System.out.println("Owner's permission : " + user_perm_string);
        System.out.println("Group's permission : " + group_perm_string);
        System.out.println("User's permission  : " + owner_perm_string);
        System.out.println("\n");
    }

    private String interpretPermission(int permission) {
        String permString = null;
        switch (permission) {
            case 7:
                permString = "READ, WRITE, EXECUTE";
                break;
            case 6:
                permString = "READ, WRITE";
                break;
            case 5:
                permString = "READ, EXECUTE";
                break;
            case 4:
                permString = "READ";
                break;
            case 3:
                permString = "WRITE, EXECUTE";
                break;
            case 2:
                permString = "WRITE";
                break;
            case 1:
                permString = "EXECUTE";
                break;
            case 0:
                permString = "NONE";
                break;
        }
        return permString;
    }

    public static void main(String [] args) {

        Bitmask bm = new Bitmask();
        short p1 = 0b0000_0001_1100_0000; // owner read, write, execute
        short p2 = 0x0654;
        short p3 = 0x0666;
        short p4 = 0x0257;

        bm.printPermission(p1);
        bm.printPermission(p2);
        bm.printPermission(p3);
        bm.printPermission(p4);
    }
}