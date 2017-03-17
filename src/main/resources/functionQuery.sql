/* 该脚本存储项目中所需要的功能查询语句 */

/* 1. 查询个人的菜单信息 */
/* 子句 */
SELECT * FROM menu where `is_valid` = '1' and ISNULL(`father_menu_id`); /* 筛选一级菜单 */
SELECT * FROM menu where `is_valid` = '1' and IFNULL(`father_menu_id`, NULL); /* 筛选二级菜单 */
/* 结果 */
SELECT one.*, two.url _url,two.title _title,two.desc _desc,two.image _image FROM
	(SELECT * FROM menu WHERE `is_valid` = '1' AND ISNULL(`father_menu_id`)) one,
	(SELECT * FROM menu WHERE `is_valid` = '1' AND IFNULL(`father_menu_id`, NULL)) two
WHERE
	one.`id`=two.`father_menu_id` AND one.`level` = 'T'
ORDER BY one.order,two.order