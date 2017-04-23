/* 该脚本存储项目中所需要的功能查询语句 */

/* 1. 查询个人的菜单信息 */
/* 子句 */
SELECT * FROM menu where `is_valid` = '1' and ISNULL(`father_menu_id`); /* 筛选一级菜单 */
SELECT * FROM menu where `is_valid` = '1' and IFNULL(`father_menu_id`, NULL); /* 筛选二级菜单 */
/* 结果 */
SELECT one.*, two.url _url,two.title _title,two.desc _desc,two.image _image FROM
	(SELECT * FROM menu WHERE `is_valid` = '1' AND ISNULL(`father_menu_id`)) one LEFT JOIN
	(SELECT * FROM menu WHERE `is_valid` = '1' AND IFNULL(`father_menu_id`, NULL)) two
ON one.`id`=two.`father_menu_id`
WHERE one.`level` = 'T'
ORDER BY one.order,two.order;

/* 学生查询老师发给自己的消息 */
select * from message where is_valid = 'Y' and type = 'TTS' and receiver_id = '1';
/* 学生查询同学发给自己的消息 */
select * from message where is_valid = 'Y' and type = 'STS' and receiver_id = '1';
									/*||*/
                                    /*||*/
                                    /*|| =由上面两条语句可以得出*/
                                    /*||*/
                                    /*||*/
                                  /*--  --*/
                                  /*\    /*/
                                   /*\  /*/
                                    /*\/*/
select * from message where is_valid = 'Y' and type IN ('STS','STS') and receiver_id = '1';

/* 学生查询自己发给老师的消息 */
select * from message where is_valid = 'Y' and type = 'STT' and sender_id = '1';
/* 学生查询自己发给同学的消息 */
select * from message where is_valid = 'Y' and type = 'STS' and sender_id = '1';
									/*||*/
                                    /*||*/
                                    /*|| =由上面两条语句可以得出*/
                                    /*||*/
                                    /*||*/
                                  /*--  --*/
                                  /*\    /*/
                                   /*\  /*/
                                    /*\/*/
select * from message where is_valid = 'Y' and type IN ('STS', 'STT') and sender_id = '1';



/* 老师查询学生发给自己的消息 */
select * from message where is_valid = 'Y' and type = 'STT' and receiver_id = '1';
/* 老师查询同事发给自己的消息 */
select * from message where is_valid = 'Y' and type = 'TTT' and receiver_id = '1';
									/*||*/
                                    /*||*/
                                    /*|| =由上面两条语句可以得出*/
                                    /*||*/
                                    /*||*/
                                  /*--  --*/
                                  /*\    /*/
                                   /*\  /*/
                                    /*\/*/
select * from message where is_valid = 'Y' and type IN ('STT','TTT') and receiver_id = '1';

/* 老师查询自己发给学生的消息 */
select * from message where is_valid = 'Y' and type = 'TTS' and sender_id = '1';
/* 老师查询自己发给同事的消息 */
select * from message where is_valid = 'Y' and type = 'TTT' and sender_id = '1';
									/*||*/
                                    /*||*/
                                    /*|| =由上面两条语句可以得出*/
                                    /*||*/
                                    /*||*/
                                  /*--  --*/
                                  /*\    /*/
                                   /*\  /*/
                                    /*\/*/
select * from message where is_valid = 'Y' and type IN ('TTS', 'TTT') and sender_id = '1';