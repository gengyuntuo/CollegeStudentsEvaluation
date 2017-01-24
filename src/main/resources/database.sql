/* 创建和选择数据库 */
CREATE SCHEMA IF NOT EXISTS `ces` ;
USE `ces` ;

/* 卸载多有的表 */
DROP TABLE IF EXISTS `ces`.`teacher`;
DROP TABLE IF EXISTS `ces`.`institute`;
DROP TABLE IF EXISTS `ces`.`major`;
DROP TABLE IF EXISTS `ces`.`student`;
DROP TABLE IF EXISTS `ces`.`setting`;

/* 创建数据表 */
CREATE TABLE IF NOT EXISTS `ces`.`teacher` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `nick` VARCHAR(45) NOT NULL DEFAULT '昵称' COMMENT '昵称',
  `name` VARCHAR(45) NOT NULL COMMENT '姓名',
  `nation` VARCHAR(5) NOT NULL DEFAULT '汉' COMMENT '民族',
  `gender` VARCHAR(1) NOT NULL DEFAULT '男' COMMENT '性别',
  `birthday` DATE NULL COMMENT '生日',
  `portrait` VARCHAR(140) NULL COMMENT '头像',
  `email` VARCHAR(45) NULL COMMENT '邮件',
  `id_card` VARCHAR(45) NULL COMMENT '身份证',
  `we_chat` VARCHAR(45) NULL COMMENT '微信',
  `qq_numb` VARCHAR(45) NULL COMMENT 'QQ号',
  `alipay` VARCHAR(45) NULL COMMENT '支付宝账户',
  `phone` VARCHAR(45) NULL COMMENT '电话',
  `address` VARCHAR(140) NULL COMMENT '户籍所在地',
  `resident` VARCHAR(140) NULL COMMENT '居住地',
  `motto` VARCHAR(140) NULL COMMENT '座右铭',
  `password` VARCHAR(32) NOT NULL COMMENT '密码',
  `is_valid` VARCHAR(1) NOT NULL DEFAULT 'Y' COMMENT '当前账户是否有效',
  `c_time` DATETIME NOT NULL COMMENT '创建时间',
  `u_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`))
COMMENT = '教师表';

CREATE TABLE IF NOT EXISTS `ces`.`institute` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `i_numb` VARCHAR(45) NOT NULL COMMENT '学院编号',
  `i_name` VARCHAR(45) NOT NULL COMMENT '学院名称',
  `desc` VARCHAR(140) NOT NULL COMMENT '学院说明',
  `is_valid` VARCHAR(1) NOT NULL DEFAULT 'Y' COMMENT '当前字段是否有效',
  `c_time` DATETIME NOT NULL COMMENT '创建时间',
  `u_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`))
COMMENT = '学院';

CREATE TABLE IF NOT EXISTS `ces`.`major` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `m_numb` VARCHAR(45) NOT NULL COMMENT '专业编码',
  `m_name` VARCHAR(45) NOT NULL COMMENT '专业名称',
  `desc` VARCHAR(140) NOT NULL COMMENT '专业说明',
  `institute_id` INT NOT NULL COMMENT '隶书学院ID',
  `is_valid` VARCHAR(1) NOT NULL DEFAULT 'Y' COMMENT '该字段是否有效',
  `c_time` DATETIME NOT NULL COMMENT '创建时间',
  `u_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`))
COMMENT = '专业';

CREATE TABLE IF NOT EXISTS `ces`.`student` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `nick` VARCHAR(45) NOT NULL DEFAULT '昵称' COMMENT '昵称',
  `name` VARCHAR(45) NOT NULL COMMENT '姓名',
  `nation` VARCHAR(5) NOT NULL DEFAULT '汉' COMMENT '民族',
  `gender` VARCHAR(1) NOT NULL DEFAULT '男' COMMENT '性别',
  `birthday` DATE NULL COMMENT '生日',
  `portrait` VARCHAR(140) NULL COMMENT '头像',
  `role` VARCHAR(45) NULL COMMENT '职位',
  `email` VARCHAR(45) NULL COMMENT '邮件',
  `id_card` VARCHAR(45) NULL COMMENT '身份证',
  `we_chat` VARCHAR(45) NULL COMMENT '微信',
  `qq_numb` VARCHAR(45) NULL COMMENT 'QQ号',
  `alipay` VARCHAR(45) NULL COMMENT '支付宝账户',
  `phone` VARCHAR(45) NULL COMMENT '电话',
  `address` VARCHAR(140) NULL COMMENT '户籍所在地',
  `resident` VARCHAR(140) NULL COMMENT '居住地',
  `motto` VARCHAR(140) NULL COMMENT '座右铭',
  `password` VARCHAR(32) NOT NULL COMMENT '密码',
  `class_id` INT NOT NULL COMMENT '班级的ID',
  `major_id` INT NOT NULL COMMENT '专业ID',
  `teacher_id` INT NOT NULL COMMENT '老师ID',
  `study_year` INT NOT NULL DEFAULT 4 COMMENT '学习年限',
  `start_year` DATE NOT NULL COMMENT '入学日期',
  `stop_year` DATE NOT NULL COMMENT '学业结束日期',
  `is_valid` VARCHAR(1) NOT NULL DEFAULT 'Y' COMMENT '该字段是否有效',
  `c_time` DATETIME NOT NULL COMMENT '创建时间',
  `u_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`))
COMMENT = '学生';

CREATE TABLE IF NOT EXISTS `ces`.`setting` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(1) NOT NULL COMMENT '角色',
  `owner_id` INT NOT NULL COMMENT '拥有者',
  `setting` VARCHAR(45) NOT NULL COMMENT '设置选项',
  `value` VARCHAR(45) NOT NULL COMMENT '选项值',
  PRIMARY KEY (`id`))
COMMENT = '系统设置';










