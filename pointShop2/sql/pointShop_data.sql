use point_shop;
#在中文windows通过mysql命令进行数据库操作需要更改字符集为gbk
set  character_set_server=gbk;
set  character_set_client=gbk;
set  character_set_results=gbk;
set  character_set_connection=gbk;
set  character_set_filesystem=gbk;
insert into `tb_goods`(`name`, `description`, `original_point`, `now_point`, `published`, `is_delete`)
                values('研磨设计模式', '一本值得反复阅读的书', '200', '100', true, false );