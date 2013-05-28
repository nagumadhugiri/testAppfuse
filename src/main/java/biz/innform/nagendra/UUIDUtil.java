package biz.innform.nagendra;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: Nagendra
 * Date: 10/31/12
 * Time: 11:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class UUIDUtil {
    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString());
        String encodedUUID = encodeUuid(uuid);
        System.out.println(encodedUUID);
        System.out.println(decodeUuid(encodedUUID));
    }
    static String encodeUuid(final UUID id) {
        final long hi = id.getMostSignificantBits();
        final long lo = id.getLeastSignificantBits();
        return new String(new char[] {
                (char) ((hi >>> 48) & 0xffff), (char) ((hi >>> 32) & 0xffff),
                (char) ((hi >>> 16) & 0xffff), (char) ((hi       ) & 0xffff),
                (char) ((lo >>> 48) & 0xffff), (char) ((lo >>> 32) & 0xffff),
                (char) ((lo >>> 16) & 0xffff), (char) ((lo       ) & 0xffff)
        });
    }

    static UUID decodeUuid(final String enc) {
        final char[] cs = enc.toCharArray();
        return new UUID(
                (long) cs[0] << 48 | (long) cs[1] << 32 | (long) cs[2] << 16 | (long) cs[3],
                (long) cs[4] << 48 | (long) cs[5] << 32 | (long) cs[6] << 16 | (long) cs[7]
        );
    }
}
