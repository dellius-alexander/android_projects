package com.skillsoft.currencyconverter

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

var validUserID = "john.doe@gmail.com"
var invalidUserID = "xyz.com"
var validDOB = "20/01/1996"
var invalidDOB = "1996-01-05"


class SignUpPageUtilsTest {
    private lateinit var utils: SignUpUtils

    @Before
    fun setup(){
        utils = SignUpUtils()
    }

    @Test
    fun validEmail(){
        assert(utils.isValidEmail(validUserID))
    }

    @Test
    fun invalidEmail(){
        assert(!utils.isValidEmail(invalidUserID))
    }

    @Test
    fun validDOB(){
        assert(utils.isValidDOB(validDOB))
    }

    @Test
    fun invalidDOB(){
        assert(!utils.isValidDOB(invalidDOB))
    }

    @Test
    fun localPartLength(){
        assertEquals(8, utils.getLocalPartLength(validUserID))
    }

}