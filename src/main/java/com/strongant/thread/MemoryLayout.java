package com.strongant.thread;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

public class MemoryLayout {

    private static final Unsafe unsafe;

    private boolean v;
    private boolean v0;
    private int v1;
    private int v2;
    private boolean[] bools;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField( "theUnsafe" );
            field.setAccessible( true );
            unsafe = (Unsafe) field.get( null );
        }
        catch (Exception e) {
            throw new RuntimeException( e );
        }
    }

    public static void main(String[] args) throws Exception {

        MemoryLayout layout = new MemoryLayout();
        layout.v0 = true;
        layout.v1 = 4;
        layout.v2 = 4;
        layout.bools = new boolean[]{true};

        System.out.println( unsafe.objectFieldOffset( MemoryLayout.class.getDeclaredField("v") ) );
        System.out.println( unsafe.objectFieldOffset( MemoryLayout.class.getDeclaredField("v0") ) );
        System.out.println( unsafe.objectFieldOffset( MemoryLayout.class.getDeclaredField("v1") ) );
        System.out.println( unsafe.objectFieldOffset( MemoryLayout.class.getDeclaredField("v2") ) );

        System.out.println( unsafe.objectFieldOffset( MemoryLayout.class.getDeclaredField("bools") ) );

        int size = unsafe.arrayIndexScale(boolean[].class);
        System.out.println("bool size : " + size);
    }
}