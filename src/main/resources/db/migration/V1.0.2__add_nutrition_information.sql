# create a reusable function to check if a columns exists
DROP FUNCTION IF EXISTS column_exists;

DELIMITER $$
CREATE FUNCTION column_exists(
    tname VARCHAR(64),
    cname VARCHAR(64)
)
    RETURNS BOOLEAN
    READS SQL DATA
BEGIN
    RETURN 0 < (SELECT COUNT(*)
                FROM `INFORMATION_SCHEMA`.`COLUMNS`
                WHERE `TABLE_SCHEMA` = SCHEMA()
                  AND `TABLE_NAME` = tname
                  AND `COLUMN_NAME` = cname);
END $$
DELIMITER ;

# create a reusable function/procedure to drop a column if it exists

DROP PROCEDURE IF EXISTS drop_column_if_exists;

DELIMITER $$
CREATE PROCEDURE drop_column_if_exists(
    tname VARCHAR(64),
    cname VARCHAR(64)
)
BEGIN
    IF column_exists(tname, cname)
    THEN
        SET @add_column_if_not_exists = CONCAT('ALTER TABLE `', tname, '` DROP COLUMN `', cname, '`');
        PREPARE drop_query FROM @add_column_if_not_exists;
        EXECUTE drop_query;
    END IF;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS add_column_if_not_exists;

DELIMITER $$
CREATE PROCEDURE add_column_if_not_exists(
    tname VARCHAR(64),
    cname VARCHAR(64),
    qualifiers VARCHAR(64)
)
BEGIN
    IF not column_exists(tname, cname)
    THEN
        SET @add_column_if_not_exists = CONCAT('ALTER TABLE `', tname, '` ADD COLUMN `', cname, '` ', qualifiers);
        PREPARE add_query FROM @add_column_if_not_exists;
        EXECUTE add_query;
    END IF;
END $$
DELIMITER ;

CALL drop_column_if_exists('ingredients', 'proteins');
CALL drop_column_if_exists('ingredients', 'fats');
CALL drop_column_if_exists('ingredients', 'carbs');
CALL drop_column_if_exists('ingredients', 'calories');

create table if not exists macro_nutrient_info
(
    id       bigint unsigned auto_increment primary key not null,
    calories bigint unsigned                            not null,
    protein  bigint unsigned                            not null,
    carbs    bigint unsigned                            not null,
    fat      bigint unsigned                            not null
);

create table if not exists nutrient_extra_info
(
    id    bigint unsigned auto_increment primary key not null,
    fiber bigint unsigned                            null,
    sugar bigint unsigned                            not null
);

create table if not exists vitamin_info
(
    id          bigint unsigned auto_increment primary key not null,
    vitamin_A   float unsigned                             null,
    vitamin_B2  float unsigned                             null,
    vitamin_B3  float unsigned                             null,
    vitamin_B5  float unsigned                             null,
    vitamin_B6  float unsigned                             null,
    vitamin_B12 float unsigned                             null,
    vitamin_D   float unsigned                             null,
    vitamin_E   float unsigned                             null,
    vitamin_K   float unsigned                             null
);

create table if not exists micro_nutrient_info
(
    id         bigint unsigned auto_increment primary key not null,
    biotin     float unsigned                             null,
    calcium    float unsigned                             null,
    copper     float unsigned                             null,
    iron       float unsigned                             null,
    phosphorus float unsigned                             null,
    potassium  float unsigned                             null,
    magnesium  float unsigned                             not null,
    selenium   float unsigned                             null,
    zinc       float unsigned                             null

);

CREATE TABLE IF NOT EXISTS nutrition
(
    id                     bigint unsigned auto_increment primary key not null,
    macro_nutrient_id      bigint unsigned                            not null,
    extra_info_id          bigint unsigned                            not null,
    vitamin_info_id        bigint unsigned                            null,
    micro_nutrient_info_id bigint unsigned                            null,

    constraint foreign key (macro_nutrient_id) references macro_nutrient_info (id),
    constraint foreign key (extra_info_id) references nutrient_extra_info (id),
    constraint foreign key (vitamin_info_id) references vitamin_info (id),
    constraint foreign key (micro_nutrient_info_id) references micro_nutrient_info (id)
);

CALL add_column_if_not_exists('ingredients', 'nutrition_id', 'bigint unsigned not null');

DELIMITER //

CREATE PROCEDURE add_constraint_if_not_exists(
    IN databaseName VARCHAR(64),
    IN tableName VARCHAR(64),
    IN constraintName VARCHAR(64),
    IN constraintSQL TEXT
)
BEGIN
    DECLARE constraintCount INT;

    SELECT COUNT(*)
    INTO constraintCount
    FROM information_schema.table_constraints
    WHERE table_schema = databaseName
      AND table_name = tableName
      AND constraint_name = constraintName;

    IF constraintCount = 0 THEN
        SET @sql = CONCAT('ALTER TABLE ', databaseName, '.', tableName, ' ADD CONSTRAINT ', constraintSQL);
        PREPARE stmt FROM @sql;
        EXECUTE stmt;
        DEALLOCATE PREPARE stmt;
    END IF;
END //

DELIMITER ;

CALL add_constraint_if_not_exists('recipe_base', 'ingredients', 'nutrition_foreign_key',
                                  'FOREIGN KEY (nutrition_id) REFERENCES nutrition (id)');
