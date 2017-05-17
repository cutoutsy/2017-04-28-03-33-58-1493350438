public class BowlingGame {

    public int getBowlingScore(String bowlingCode) {
         String bowlingCodeHead = bowlingCode.split("\\|\\|")[0];
        String bowlingCodeEnd = "";
        if(!bowlingCode.endsWith("|")){
            bowlingCodeEnd = bowlingCode.split("\\|\\|")[1];
        }

        String[] tenTimes = bowlingCodeHead.split("\\|");
        int totalTime = 10+ bowlingCodeEnd.length();

        String[] endTimes = new String[totalTime];
        for (int i = 0; i < tenTimes.length; i++) {
            endTimes[i] = tenTimes[i];
        }

        if(bowlingCodeEnd.length()==1){
            endTimes[10] = bowlingCodeEnd;
        }else if(bowlingCodeEnd.length()==2){
            endTimes[10] = String.valueOf(bowlingCodeEnd.charAt(0));
            endTimes[11] = String.valueOf(bowlingCodeEnd.charAt(1));
        }

        int totalScore = 0;

        for (int i = 0; i < 10; i++) {
            String frame = endTimes[i];
            if(frame.length()==1) {
                totalScore+=10;
                String second = endTimes[i+1];
                if(second.length()==2){
                    if(second.contains("/")){
                        totalScore+=10;
                    }else{
                        String tempScore = Character.isDigit(second.charAt(0)) ? String.valueOf(second.charAt(0)) : String.valueOf(second.charAt(1));
                        totalScore+= Integer.valueOf(tempScore);
                    }
                }else{
                    if(second.equals("X")) {
                        totalScore += 10;
                    }else{
                        String tempScore = Character.isDigit(second.charAt(0)) ? String.valueOf(second.charAt(0)) : "0";
                        totalScore+= Integer.valueOf(tempScore);
                    }
                    String third = endTimes[i+2];
                    if(third.length()==1 && third.equals("X")){
                        totalScore+=10;
                    }else {
                        String tempScore = Character.isDigit(third.charAt(0)) ? String.valueOf(third.charAt(0)) : "0";
                        totalScore+= Integer.valueOf(tempScore);
                    }
                }
            }else{
                if(frame.contains("/")){
                    totalScore+=10;
                    String second = endTimes[i+1];
                    if(second.length()==1 && second.equals("X")){
                        totalScore+=10;
                    }else{
                        String tempScore = Character.isDigit(second.charAt(0)) ? String.valueOf(second.charAt(0)) : "0";
                        totalScore+= Integer.valueOf(tempScore);
                    }
                }else{
                    String tempScore = Character.isDigit(frame.charAt(0)) ? String.valueOf(frame.charAt(0)) : String.valueOf(frame.charAt(1));
                    totalScore+= Integer.valueOf(tempScore);
                }
            }
        }
        return totalScore;
    }
}
