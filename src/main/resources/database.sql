/* 创建和选择数据库 */
CREATE SCHEMA IF NOT EXISTS `ces` ;
USE `ces` ;

/* 卸载多有的表 */
DROP TABLE IF EXISTS `ces`.`teacher`;
DROP TABLE IF EXISTS `ces`.`institute`;
DROP TABLE IF EXISTS `ces`.`major`;
DROP TABLE IF EXISTS `ces`.`student`;
DROP TABLE IF EXISTS `ces`.`setting`;
DROP TABLE IF EXISTS `ces`.`menu`;

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
  `staryear` DATE NOT NULL COMMENT '入学日期',
  `stop_year` DATE NOT NULL COMMENT '学业结束日期',
  `is_valid` VARCHAR(1) NOT NULL DEFAULT 'Y' COMMENT '该字段是否有效',
  `c_time` DATETIME NOT NULL COMMENT '创建时间',
  `u_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`))
COMMENT = '学生';

CREATE TABLE IF NOT EXISTS `ces`.`setting` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `weight` INT NOT NULL DEFAULT 0 COMMENT '权重，用于显示菜单的顺序',
  `type` VARCHAR(45) NOT NULL COMMENT '类型',
  `owner_id` INT NOT NULL COMMENT '拥有者',
  `setting` VARCHAR(45) NOT NULL COMMENT '设置选项',
  `value` VARCHAR(45) NOT NULL COMMENT '选项值',
  PRIMARY KEY (`id`))
COMMENT = '系统设置';

CREATE TABLE IF NOT EXISTS `ces`.`menu` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `url` VARCHAR(200) NOT NULL COMMENT '菜单指向的页面路径',
  `title` VARCHAR(45) NOT NULL COMMENT '菜单标题',
  `desc` VARCHAR(140) NOT NULL DEFAULT '菜单' COMMENT '菜单功能描述',
  `image` VARCHAR(200) NOT NULL DEFAULT '无' COMMENT '菜单图标',
  `role_id` INT NULL COMMENT '菜单拥有者ID',
  `father_menu_id` INT NULL COMMENT '父菜单的ID',
  `level` VARCHAR(1) NOT NULL DEFAULT 'U' COMMENT '菜单使用权限',
  PRIMARY KEY (`id`))
COMMENT = '用户菜单';

CREATE TABLE IF NOT EXISTS `ces`.`term` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` VARCHAR(45) UNIQUE NOT NULL COMMENT '学期名称',
  `desc` VARCHAR(140) UNIQUE NOT NULL COMMENT '学期描述',
  `start_date` DATETIME NOT NULL COMMENT '学期开始时间',
  `stop_date` DATETIME NOT NULL COMMENT '学期结束时间',
  `is_valid` VARCHAR(1) NOT NULL COMMENT '是否有效',
  `c_time` DATETIME NOT NULL COMMENT '创建时间',
  `u_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) COMMENT '学期';


/* 综合测评统计表 */
CREATE TABLE IF NOT EXISTS `ces`.`t_zhcpcjtj` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `sno` VARCHAR(45) NOT NULL COMMENT '该表对应的学生',
  `term_id` INT NOT NULL DEFAULT 0 COMMENT '评分表创建的学期',
  `ri_chang_xing_wei_id` INT NOT NULL DEFAULT 0 COMMENT '日常行为部分评分表ID',
  `su_zhi_huo_dong_id` INT NOT NULL DEFAULT 0 COMMENT '素质活动评分表ID',
  `ping_jun_xue_fen_ji_dian` DOUBLE NOT NULL DEFAULT 0 COMMENT '平均学分绩点',
  `is_valid` VARCHAR(1) NULL DEFAULT 'N' COMMENT '标志此表是否审核过',
  `c_time` DATETIME NOT NULL COMMENT '创建时间',
  `u_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) COMMENT '综合测评成绩统计表';

/* 素质教育加分评分表 */
CREATE TABLE IF NOT EXISTS `ces`.`t_szjyjfpf` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `zong_he_id` INT NOT NULL DEFAULT 0 COMMENT '综合测评表ID',
  `she_hui_fu_wu` DOUBLE NOT NULL DEFAULT 0 COMMENT '社会服务',
  `she_hui_shi_jian` DOUBLE NOT NULL DEFAULT 0 COMMENT '社会实践',
  `bi_sai_huo_jiang` DOUBLE NOT NULL DEFAULT 0 COMMENT '比赛获奖',
  `xue_sheng_gan_bu` DOUBLE NOT NULL DEFAULT 0 COMMENT ' 学生干部',
  `is_valid` VARCHAR(1) NULL DEFAULT 'N' COMMENT '标志此表是否审核过',
  `c_time` DATETIME NOT NULL COMMENT '创建时间',
  `u_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) COMMENT '素质教育加分评分';

/* 素质教育加分申请表 */
CREATE TABLE IF NOT EXISTS `ces`.`t_szjyjfsq` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `suzhi` INT NOT NULL DEFAULT 0  COMMENT '素质加分测评表ID',
  `name` VARCHAR(200) NULL COMMENT '比赛或者职务名称',
  `type` VARCHAR(45) NULL COMMENT '类型',
  `time` VARCHAR(45) NULL COMMENT '时间',
  `level` VARCHAR(45) NULL COMMENT '等级',
  `evidence` VARCHAR(200) NULL COMMENT '证据',
  `filePath` VARCHAR(200) NULL COMMENT '证明文件的上传文件',
  `score` DOUBLE NULL DEFAULT 0 COMMENT '成绩',
  `isvalid` VARCHAR(1) NULL DEFAULT 'N' COMMENT '检测该加分项是否通过认证',
  `c_time` DATETIME NOT NULL COMMENT '创建时间',
  `u_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) COMMENT '素质教育加分申请表';

/* 素质学分日常行为部分评分表 */
CREATE TABLE IF NOT EXISTS `ces`.`t_szxfrcxwbfpf` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `zong_he_id` INT NOT NULL DEFAULT 0 COMMENT '综合测评表ID',
  `she_hui_gong_de` DOUBLE NOT NULL DEFAULT 0 COMMENT '社会公德',
  `wen_ming_jiao_wang` DOUBLE NOT NULL DEFAULT 0 COMMENT '文明交往',
  `cheng_xin_li_shen` DOUBLE NOT NULL DEFAULT 0 COMMENT '诚信立身',
  `ti_yu_duan_lian` DOUBLE NOT NULL DEFAULT 0 COMMENT '体育锻炼',
  `ai_hu_gong_wu` DOUBLE NOT NULL DEFAULT 0 COMMENT '爱护公物',
  `xue_xiao_gui_ding` DOUBLE NOT NULL DEFAULT 0 COMMENT '学校规定',
  `can_jia_huo_dong` DOUBLE NOT NULL DEFAULT 0 COMMENT '参加活动',
  `ting_ke_ji_lu` DOUBLE NOT NULL DEFAULT 0 COMMENT '听课记录',
  `gong_yu_jian_cha` DOUBLE NOT NULL DEFAULT 0 COMMENT '公寓检查',
  `is_valid` VARCHAR(1) NULL DEFAULT 'N' COMMENT '标志此表是否审核过',
  `c_time` DATETIME NOT NULL COMMENT '创建时间',
  `u_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) COMMENT '素质学分日常行为部分评分表';




