/* 创建和选择数据库 */
CREATE SCHEMA IF NOT EXISTS `ces` ;
USE `ces` ;

/* 卸载多有的表 */
DROP TABLE IF EXISTS `ces`.`teacher`;
DROP TABLE IF EXISTS `ces`.`institute`;
DROP TABLE IF EXISTS `ces`.`major`;
DROP TABLE IF EXISTS `ces`.`class`;
DROP TABLE IF EXISTS `ces`.`student`;
DROP TABLE IF EXISTS `ces`.`setting`;
DROP TABLE IF EXISTS `ces`.`menu`;
DROP TABLE IF EXISTS `ces`.`setting`;

/* 创建数据表 */
DROP TABLE IF EXISTS `ces`.`teacher`;
CREATE TABLE IF NOT EXISTS `ces`.`teacher` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `nick` VARCHAR(45) NOT NULL DEFAULT '昵称' COMMENT '昵称',
  `name` VARCHAR(45) NOT NULL COMMENT '姓名',
  `gender` VARCHAR(1) NOT NULL DEFAULT '男' COMMENT '性别',
  `nation` VARCHAR(5) NULL DEFAULT '汉' COMMENT '民族',
  `birthday` DATE NULL COMMENT '生日',
  `portrait` VARCHAR(140) NULL COMMENT '头像',
  `role` VARCHAR(45) NULL COMMENT '职务',
  `email` VARCHAR(45) UNIQUE NOT NULL COMMENT '邮件',
  `id_card` VARCHAR(45) NULL COMMENT '身份证',
  `we_chat` VARCHAR(45) NULL COMMENT '微信',
  `qq_numb` VARCHAR(45) NULL COMMENT 'QQ号',
  `alipay` VARCHAR(45) NULL COMMENT '支付宝账户',
  `phone` VARCHAR(45) NULL COMMENT '电话',
  `address` VARCHAR(140) NULL COMMENT '户籍所在地',
  `resident` VARCHAR(140) NULL COMMENT '居住地',
  `motto` VARCHAR(140) NULL COMMENT '座右铭',
  `password` VARCHAR(32) NOT NULL COMMENT '密码',
  `user_type` VARCHAR(1) NOT NULL COMMENT '用户类型 例如T：老师，S：学生，M：班委，A：管理员',
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

CREATE TABLE IF NOT EXISTS `ces`.`class` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `class_id` VARCHAR(45) NOT NULL COMMENT '班级号（名称）',
  `major_id` INT NOT NULL COMMENT '专业ID',
  `teacher_id` INT NOT NULL COMMENT '教师ID',
  `study_year` INT NULL COMMENT '学制',
  `start_year` DATE NOT NULL COMMENT '开始年月',
  `is_valid` VARCHAR(1) NOT NULL DEFAULT 'Y' COMMENT '是否有效',
  `c_time` DATETIME NOT NULL COMMENT '创建时间',
  `u_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`))
COMMENT = '班级';

/* 学生 */
DROP TABLE IF EXISTS `ces`.`student`;
CREATE TABLE IF NOT EXISTS `ces`.`student` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `nick` VARCHAR(45) NOT NULL DEFAULT '昵称' COMMENT '昵称',
  `name` VARCHAR(45) NOT NULL COMMENT '姓名',
  `gender` VARCHAR(1) NOT NULL DEFAULT '男' COMMENT '性别',
  `nation` VARCHAR(5) NULL DEFAULT '汉' COMMENT '民族',
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
  `user_type` VARCHAR(1) NOT NULL COMMENT '用户类型 例如T：老师，S：学生，M：班委，A：管理员',
  # 学生特有的字段
  `sno` INT UNIQUE NOT NULL COMMENT '学生学号',
  `class_id` INT NOT NULL COMMENT '班级的ID',
  `dormno` VARCHAR(45) NULL DEFAULT '' COMMENT '寝室楼号',
  `dorm_info` VARCHAR(45) NULL DEFAULT '' COMMENT '寝室号、床号',
  `political_status` VARCHAR(45) DEFAULT '群众' NULL COMMENT '政治面貌',
  `bank_card` VARCHAR(45) NULL DEFAULT '' COMMENT '银行卡号',
  `have_loan` VARCHAR(1) NULL DEFAULT 'N' COMMENT '是否生源地贷款',
  `have_poverty_certificate` VARCHAR(1) DEFAULT 'N' NULL COMMENT '是否有贫困证明',
  `father_name` VARCHAR(45) NULL DEFAULT '' COMMENT '父亲姓名',
  `father_phone` VARCHAR(45) NULL DEFAULT '' COMMENT '父亲电话',
  `mother_name` VARCHAR(45) NULL DEFAULT '' COMMENT '母亲姓名',
  `mother_phone` VARCHAR(45) NULL DEFAULT '' COMMENT '母亲电话',
  `is_valid` VARCHAR(1) NOT NULL DEFAULT 'Y' COMMENT '该字段是否有效',
  `c_time` DATETIME NOT NULL COMMENT '创建时间',
  `u_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`))
COMMENT = '学生';

DROP TABLE IF EXISTS `ces`.`setting`;
CREATE TABLE IF NOT EXISTS `ces`.`setting` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `type` VARCHAR(45) NOT NULL COMMENT '设置类型',
  `owner_type` VARCHAR(10) NOT NULL COMMENT '拥有类型,组成：修饰符+角色类型，（修饰符 C公有 P私有）（角色类型T 老师 A管理员 S 学生 C 公有） 例如 TP为老师私有',
  `owner_id` INT NULL COMMENT '拥有者ID',
  `group` VARCHAR(45) NOT NULL DEFAULT 0 COMMENT '设置组名',
  `setting` VARCHAR(45) NOT NULL COMMENT '选项名称',
  `value` VARCHAR(45) NULL COMMENT '选项值',
  `default_value` VARCHAR(45) NOT NULL COMMENT '设置项的默认值',
  `is_null` VARCHAR(45) NOT NULL DEFAULT 'N' COMMENT '是否可以为空 N 不可以为空, Y 可以为空',
  PRIMARY KEY (`id`))
COMMENT = '系统设置';

CREATE TABLE IF NOT EXISTS `ces`.`menu` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `order` INT NOT NULL UNIQUE DEFAULT '1' COMMENT '菜单显示的顺序',
  `url` VARCHAR(200) NOT NULL COMMENT '菜单指向的页面路径',
  `title` VARCHAR(45) NOT NULL COMMENT '菜单标题',
  `desc` VARCHAR(140) NOT NULL DEFAULT '菜单' COMMENT '菜单功能描述',
  `image` VARCHAR(200) NOT NULL DEFAULT '无' COMMENT '菜单图标',
  `father_menu_id` INT NULL COMMENT '父菜单的ID',
  `is_valid` BOOLEAN NOT NULL DEFAULT '1' COMMENT '父菜单的ID',
  `level` VARCHAR(1) NOT NULL DEFAULT 'U' COMMENT '菜单使用权限',
  PRIMARY KEY (`id`))
COMMENT = '用户菜单';

/* 统计学期,改表是在原有的项目上改进而来的，该表的每一条记录对应一个班级的一个学期的统计 */
DROP TABLE IF EXISTS `ces`.`term`;
CREATE TABLE IF NOT EXISTS `ces`.`term` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` VARCHAR(45) NOT NULL COMMENT '学期名称',
  `teacher_id` INT NOT NULL COMMENT '负责统计的教师ID',
  `desc` VARCHAR(140) NULL COMMENT '学期描述',
  `start_date` DATE NOT NULL COMMENT '统计开始日期',
  `stop_date` DATE NOT NULL COMMENT '统计结束日期',
  `is_valid` VARCHAR(1) NOT NULL COMMENT '是否有效',
  `c_time` DATETIME NOT NULL COMMENT '创建时间',
  `u_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) COMMENT '学期';

/* 统计学期中包含的班级 */
DROP TABLE IF EXISTS `ces`.`term_class`;
CREATE TABLE IF NOT EXISTS `ces`.`term_class` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `term_id` INT NOT NULL COMMENT '统计学期ID',
  `class_id` INT NOT NULL COMMENT '班级ID',
  PRIMARY KEY (`id`)
) COMMENT '统计学期的班级';


/* 综合测评统计表 */
DROP TABLE IF EXISTS `ces`.`t_zhcpcjtj`;
CREATE TABLE IF NOT EXISTS `ces`.`t_zhcpcjtj` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `sno` VARCHAR(45) NOT NULL COMMENT '该表对应的学生',
  `term_id` INT NOT NULL DEFAULT 0 COMMENT '评分表创建的学期',
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
DROP TABLE IF EXISTS `ces`.`t_szjyjfsq`;
CREATE TABLE IF NOT EXISTS `ces`.`t_szjyjfsq` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `su_zhi_id` INT NOT NULL DEFAULT 0  COMMENT '素质加分测评表ID',
  `name` VARCHAR(200) NULL COMMENT '比赛或者职务名称',
  `type` VARCHAR(45) NULL COMMENT '类型',
  `time` DATE NULL COMMENT '时间',
  `level` VARCHAR(45) NULL COMMENT '等级',
  `evidence` VARCHAR(2000) NULL COMMENT '证据',
  `file_path` VARCHAR(200) NULL COMMENT '证明文件的上传文件',
  `score` DOUBLE NULL DEFAULT 0 COMMENT '成绩',
  `is_valid` VARCHAR(1) NOT NULL DEFAULT 'N' COMMENT '检测该加分项是否通过认证',
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

/* 消息表 */
DROP TABLE IF EXISTS `ces`.`message`;
CREATE TABLE IF NOT EXISTS `ces`.`message` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `type` VARCHAR(10) NOT NULL COMMENT '消息类型（TTS->老师发送给学生）、（TTT->老师发送给老师）、（STT->学生发送给老师）、（STS->学生发送给学生）',
  `sender_id` INT NOT NULL COMMENT '发送者ID',
  `receiver_id` INT NOT NULL COMMENT '接收者ID',
  `title` VARCHAR(1000) NOT NULL COMMENT '标题',
  `content` VARCHAR(10000) NOT NULL COMMENT '内容',
  `state` VARCHAR(1) NOT NULL DEFAULT 'N' COMMENT '消息状态，是否已读等',
  `with_mail` VARCHAR(1) NULL DEFAULT 'N' COMMENT '是否有邮件通知',
  `is_valid` VARCHAR(1) NOT NULL COMMENT '消息是否有效',
  `c_time` DATETIME NOT NULL COMMENT '发送时间',
  `u_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`))
COMMENT = '消息表';




