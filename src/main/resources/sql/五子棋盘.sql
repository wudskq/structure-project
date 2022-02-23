DROP TABLE IF EXISTS array_data;
CREATE TABLE array_data(
                           id bigint(32) NOT NULL AUTO_INCREMENT  COMMENT '' ,
                           row_id int(60)    COMMENT '行号' ,
                           column_id int(60)    COMMENT '列号' ,
                           data int(60)    COMMENT '数据' ,
                           PRIMARY KEY (id)
)  COMMENT = '数组存盘表';
