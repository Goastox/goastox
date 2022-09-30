package com.goastox.asm;


public interface Opcodes {

    int magic = 0xcafebabe;

    int version =0x0000003d;

    short constant_length = 0x001a;

    // 常量项


    short access_flags = 0x0021;

    short this_class = 0x0015;

    short super_class = 0x0002;

    short interface_length = 0x0000;

    short field_length = 0x0000;

    short method_length = 0x0002;
        // 构造函数
        short method_access_flags = 0x0001;
        short method_name_index = 0x0000;
        short method_descriptor_index = 0x0000;
        short method_attributes_count = 0x0001;
        short method_attributes_name_index = 0x0000;
        int method_attributes_length = 0x0000001d;
        short method_attributes_max_stack = 0x0001;
        short method_attributes_max_locals = 0x0001;
        int method_attributes_code_length = 0x00000005;
        // 此处需要 5个字节
        short method_attributes_exception_table_length = 0x0000;
        short method_attributes_attribute_count = 0x0000;

        // main 方法
        short method_main_access_flags = 0x0001;
        short method_main_name_index = 0x0000;
        short method_main_descriptor_index = 0x0000;
        short method_main_attributes_count = 0x0001;
        short method_main_attributes_name_index = 0x0000;
        int method_main_attributes_length = 0x0000001d;
        short method_main_attributes_max_stack = 0x0001;
        short method_main_attributes_max_locals = 0x0001;
        int method_main_attributes_code_length = 0x000000032;
        // 此处需要 x个字节
        short method_main_attributes_exception_table_length = 0x0000;
        short method_main_attributes_attribute_count = 0x0000;
        short method_main_attributes_attribute_table = 0x0000;

//    short class_attribute = 0x0001;
//    short class_attribute_type = 0x0000;//source_file
//    int class_attribute_length = 0x00000002;
//    short class_attribute_source_file_index = 0x0000;





}
