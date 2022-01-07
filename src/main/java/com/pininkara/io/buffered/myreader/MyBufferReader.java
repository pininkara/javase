// 2022/1/7 14:11

package com.pininkara.io.buffered.myreader;

//做成处理流(包装流)
public class MyBufferReader extends MyReader {
    private MyReader myReader;

    public MyBufferReader(MyReader myReader) {
        this.myReader = myReader;
    }
}
