package logic;

import dao.ScoreDAO;
import entity.Player;
import entity.Score;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author baphucnguyen
 */
public class ScoreLogic extends GenericLogic<Score, ScoreDAO> {

    public static final String PLAYER_ID = "id";
    public static final String SCORE = "score";
    public static final String SUBMISSION = "submission";
    public static final String ID = "scoreid";

    public ScoreLogic() {
        super(new ScoreDAO());
    }

    public List<Score> getAll() {
        return get(() -> dao().findAll());
    }

    public List<Score> getByID(int id) {
        return get(() -> dao().findByID(id));
    }

    public List<Score> getScoresWith(int score) {
        return get(() -> dao().findByScore(score));
    }

    public List<Score> getScoreOnDate(Date submission) {
        return get(() -> dao().findBySubmission(submission));
    }
    
    public List<Score> getScoreOnDateBefore(Date submission) {
        return get(() -> dao().findBySubmissionBeforeDate(submission));
    }
    
    public List<Score> getScoreOnDateAfter(Date submission) {
        return get(() -> dao().findBySubmissionBeforeDate(submission));
    }

    public List<Score> getScoresForPlayerID(int playerid) {
        return get(() -> dao().findByPlayerID(playerid));
    }

    @Override
    public Score createEntity(Map<String, String[]> parameterMap) {
        Score score = new Score();
        PlayerLogic playerLogic = new PlayerLogic();
        Date date = java.util.Calendar.getInstance().getTime();
        //check validation input first
        if (validation(parameterMap.get(PLAYER_ID)[0], 10, false)) {
            //get player base on the ID
            try {
                Player player = playerLogic.getPlayerWithId(Integer.valueOf(parameterMap.get(PLAYER_ID)[0]));
                score.setPlayerid(player);
            } catch (Exception e) {

            }
            //set this player to Username Object
            if (parameterMap.containsKey(ID)){
                score.setId(Integer.valueOf(parameterMap.get(ID)[0]));
            }
            score.setSubmission(date);
            //ser username from input
            if (validation(parameterMap.get(SCORE)[0], 10, false)) {
                try {

                    score.setScore(Integer.valueOf(parameterMap.get(SCORE)[0]));
                } catch (Exception e) {
                }
            }
        }

        return score;
    }

    /**
     * to check the input is valid or not before create entity
     *
     * @param input : string to check, username or playerid
     * @param length : length allowed in DB
     * @param isNull : null able or not
     * @return
     */
    public boolean validation(String input, int length, boolean isNull) {

        if (!isNull) {
            if (input.equals("")) {
                return false;
            } else if (input.length() > length) {
                return false;
            }
        } else {
            if (!input.equals("")) {
                if (input.length() > length) {
                    return false;
                }
            }
        }
        return true;
    }
}
