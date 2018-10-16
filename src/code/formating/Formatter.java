package code.formating;


public class Formatter {
    static final int defaultSpaceCoef = 4;

    static String format(String str) {
        int spaceCoef = 0;
        StringBuilder sb = new StringBuilder();
        char[] strToArray = str.toCharArray();

        for (int i = 0; i < strToArray.length; i++) {

            for (int x = 0; x < spaceCoef; x++) {
                sb.append(' ');
            }

            for (int j = i; j < strToArray.length; j++, i++) {
                if (strToArray[i] == '}') {
                    spaceCoef -= defaultSpaceCoef;
                    for (int y = 0; y < defaultSpaceCoef; y++) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    sb.append('}');
                    break;
                }
                sb.append(strToArray[j]);
                if (strToArray[i] == '{') {
                    spaceCoef += defaultSpaceCoef;
                    break;
                }
                if (strToArray[j] == ';') {
                    break;
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}

