package com.example.jehad.jobfinder.test;

import com.example.jehad.jobfinder.ui.main.dialogs.FilterBaseCustomViewAlertDialog;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.Silent.class)
public class FilterCustomViewAlertDialogTest {


    @Test
    public void testValidationProviderCheckbox() {
        FilterBaseCustomViewAlertDialog filterBaseCustomViewAlertDialog = Mockito.mock(FilterBaseCustomViewAlertDialog.class);
        when(filterBaseCustomViewAlertDialog.isProviderCheckBoxChecked()).thenReturn(false);
        assertEquals(false, filterBaseCustomViewAlertDialog.isFieldsValid());
    }

    @Test
    public void testValidationPositionCheckbox() {
        FilterBaseCustomViewAlertDialog filterBaseCustomViewAlertDialog = Mockito.mock(FilterBaseCustomViewAlertDialog.class);
        when(filterBaseCustomViewAlertDialog.isLocationCheckBoxChecked()).thenReturn(false);
        assertEquals(false, filterBaseCustomViewAlertDialog.isFieldsValid());
    }

    @Test
    public void testValidationLocationCheckbox() {
        FilterBaseCustomViewAlertDialog filterBaseCustomViewAlertDialog = Mockito.mock(FilterBaseCustomViewAlertDialog.class);
        when(filterBaseCustomViewAlertDialog.isLocationCheckBoxChecked()).thenReturn(true);
        assertEquals(false, filterBaseCustomViewAlertDialog.isFieldsValid());
    }

    @Test
    public void testValidationPositionEditText() {
        FilterBaseCustomViewAlertDialog filterBaseCustomViewAlertDialog = Mockito.mock(FilterBaseCustomViewAlertDialog.class);
        when(filterBaseCustomViewAlertDialog.getPositionEditText()).thenReturn("");
        assertEquals(false , filterBaseCustomViewAlertDialog.isFieldsValid());
    }

    @Test
    public void testValidationLocationEditText() {
        FilterBaseCustomViewAlertDialog filterBaseCustomViewAlertDialog = Mockito.mock(FilterBaseCustomViewAlertDialog.class);
        when(filterBaseCustomViewAlertDialog.getLocationEditText()).thenReturn(null);
        assertEquals(false ,filterBaseCustomViewAlertDialog.isFieldsValid());
    }


}
