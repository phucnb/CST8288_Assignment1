package logic;

import dao.PlayerDAO;
import entity.Player;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author baphucnguyen
 */
public class PlayerLogic extends GenericLogic<Player, PlayerDAO> {

    public static final String ID = "id";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String JOINED = "joined";
    public static final String EMAIL = "email";

    public PlayerLogic() {
        super(new PlayerDAO());
    }

    public List<Player> getAll() {
        return get(() -> dao().findAll());
    }

    public Player getPlayerWithId(int id) {
        return get(() -> dao().findById(id));
    }

    public List<Player> getPlayersWithFirstName(String firstName) {
        return get(() -> dao().findByFirstName(firstName));
    }

    public List<Player> getPlayersWithLastName(String lastName) {
        return get(() -> dao().findByLastName(lastName));
    }

    public List<Player> getPlayersJoinedOn(Date date) {
        return get(() -> dao().findByJoined(date));
    }
    
     public List<Player> getPlayerOnDateBefore(Date date) {
        return get(() -> dao().findByJoinedBeforeDate(date));
    }
    
    public List<Player> getPlayerOnDateAfter(Date date) {
        return get(() -> dao().findByJoinedBeforeDate(date));
    }

    public Player getPlayerWithEmail(String email) {
        return get(() -> dao().findByEmail(email));
    }

    @Override
    public Player createEntity(Map<String, String[]> parameterMap) {
        Player player = new Player();
        Date date = java.util.Calendar.getInstance().getTime();
        player.setJoined(date);
        if (validation(parameterMap.get(ID)[0], 10, false)) {
            try {
                player.setId(Integer.valueOf(parameterMap.get(ID)[0]));
                if (validation(parameterMap.get(FIRST_NAME)[0], 45, false)) {
                    player.setFirstName(parameterMap.get(FIRST_NAME)[0]);
                    if (validation(parameterMap.get(LAST_NAME)[0], 45, false)) {
                        player.setLastName(parameterMap.get(LAST_NAME)[0]);
                        System.out.println(parameterMap.get(EMAIL)[0] != null);
                        if (!parameterMap.get(EMAIL)[0].equals("")) {
                            player.setEmail(parameterMap.get(EMAIL)[0]);

                        }
                    }
                }
            } catch (Exception e) {

            }

        }
        return player;
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
