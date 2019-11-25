package ua.com.epam.utils.helpers;

public interface SqlQuery {
    String AUTHOR = "author";

    String INSERT_AUTHOR = "INSERT INTO `%s`.`%s` (" +
            "authorId," +
            " `authorName.first`, " +
            "`authorName.second`," +
            " `birth.city`, " +
            "`birth.country`, " +
            "`birth.date`," +
            " authorDescription," +
            " nationality)" +
            "  VALUES(" +
            "%s ," +
            "'%s' ," +
            "'%s' ," +
            "'%s' ," +
            "'%s' ," +
            "'%s' ," +
            "'%s' ," +
            "'%s' );";

    String SELECT_RANDOM_ONE = "SELECT * FROM `%s`.`%s` ORDER BY RAND() LIMIT 1";
    String SELECT_DEFAULTS = "SELECT * FROM `%s`.`%s` ORDER BY `%s` ASC LIMIT 10";
    String SELECT_CUSTOMS = "SELECT * FROM `%s`.`%s` ORDER BY `%s` %s LIMIT %d";
}