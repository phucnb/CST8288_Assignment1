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

    public List<Player> getPlayersWIthLastName(String lastName) {
        return get(() -> dao().findByLastName(lastName));
    }

    public List<Player> getPlayersJoinedOn(Date date) {
        return get(() -> dao().findByJoined(date));
    }

    public Player getPlayerWithEmail(String email) {
        return get(() -> dao().findByEmail(email));
    }

    @Override
    public Player createEntity(Map<String, String[]> parameterMap) {
        Player player = new Player();
        if (!parameterMap.get(ID)[0].equals("") && parameterMap.get(ID)[0].length() < 10) {
            try {
                player.setId(Integer.valueOf(parameterMap.get(ID)[0]));
                if (!parameterMap.get(FIRST_NAME)[0].equals("") && parameterMap.get(FIRST_NAME)[0].length() < 45) {
                    player.setFirstName(parameterMap.get(FIRST_NAME)[0]);
                    if (!parameterMap.get(LAST_NAME)[0].equals("") && parameterMap.get(LAST_NAME)[0].length() < 45) {
                        player.setFirstName(parameterMap.get(LAST_NAME)[0]);

                        String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
                        Pattern pattern = Pattern.compile(EMAIL_REGEX);
                        Matcher matcher = pattern.matcher(parameterMap.get(EMAIL)[0]);
                        if (!parameterMap.get(EMAIL)[0].equals("") && parameterMap.get(EMAIL)[0].length() < 255 && matcher.matches()) {
                            player.setEmail(parameterMap.get(EMAIL)[0]);
                        }
                    }
                }

            } catch (Exception e) {
                System.out.println(e.toString());
            }

//            player.setFirstName(parameterMap.get(FIRST_NAME)[0]);
//            player.setLastName(parameterMap.get(LAST_NAME)[0]);
//            if (parameterMap.containsKey(EMAIL)) {
//                player.setEmail(parameterMap.get(EMAIL)[0]);
//            }
//            System.out.println(parameterMap.get(JOINED)[0]);
//            if (parameterMap.containsKey(JOINED)) {
//                try {
//                    player.setJoined(new SimpleDateFormat("yyyy-MM-dd").parse(parameterMap.get(JOINED)[0]));
//                } catch (ParseException ex) {
//                    Logger.getLogger(PlayerLogic.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            } else {
//                player.setJoined(java.util.Calendar.getInstance().getTime());
//            }
        }

        return player;
    }

}
