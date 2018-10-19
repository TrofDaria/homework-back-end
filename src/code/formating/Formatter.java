package code.formating;


public class Formatter {
    static final int spaceCoef = 4;

    static String format(String str) {
        int currentSpaceCoef = 0;
        StringBuilder sb = new StringBuilder();
        char[] arr = str.toCharArray();

        for (int i = 0; i < arr.length; i++) {

            for (int x = 0; x < currentSpaceCoef; x++) {
                sb.append(' ');
            }

            for (int j = i; j < arr.length; j++, i++) {
                if (arr[i] == '}') {
                    currentSpaceCoef -= spaceCoef;
                    for (int y = 0; y < spaceCoef; y++) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    sb.append('}');
                    break;
                }

                if (sb.length() == 0) {
                    if (arr[j] != ' ')
                        sb.append(arr[j]);
                } else {
                    if (!(sb.charAt(sb.length() - (currentSpaceCoef+1)) == '\n' && arr[j] == ' '))
                        sb.append(arr[j]);

                }

                if (arr[i] == '{') {
                    currentSpaceCoef += spaceCoef;
                    break;
                }
                if (arr[j] == ';') {
                    break;
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}

