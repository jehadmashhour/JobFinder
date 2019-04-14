package com.example.jehad.jobfinder.data;

import com.example.jehad.jobfinder.ui.main.dialogs.FilterCustomViewAlertDialog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.Silent.class)
public class FilterCustomViewAlertDialogTest {


    @Test
    public void testValidationProviderCheckbox() {
        FilterCustomViewAlertDialog filterCustomViewAlertDialog = Mockito.mock(FilterCustomViewAlertDialog.class);
        when(filterCustomViewAlertDialog.isProviderCheckBoxChecked()).thenReturn(false);
        assertEquals(false, filterCustomViewAlertDialog.isFieldsValid());
    }

    @Test
    public void testValidationPositionCheckbox() {
        FilterCustomViewAlertDialog filterCustomViewAlertDialog = Mockito.mock(FilterCustomViewAlertDialog.class);
        when(filterCustomViewAlertDialog.isLocationCheckBoxChecked()).thenReturn(false);
        assertEquals(false, filterCustomViewAlertDialog.isFieldsValid());
    }

    @Test
    public void testValidationLocationCheckbox() {
        FilterCustomViewAlertDialog filterCustomViewAlertDialog = Mockito.mock(FilterCustomViewAlertDialog.class);
        when(filterCustomViewAlertDialog.isLocationCheckBoxChecked()).thenReturn(true);
        assertEquals(false, filterCustomViewAlertDialog.isFieldsValid());
    }

    @Test
    public void testValidationPositionEditText() {
        FilterCustomViewAlertDialog filterCustomViewAlertDialog = Mockito.mock(FilterCustomViewAlertDialog.class);
        when(filterCustomViewAlertDialog.getPositionEditText()).thenReturn("");
        assertEquals(false , filterCustomViewAlertDialog.isFieldsValid());
    }

    @Test
    public void testValidationLocationEditText() {
        FilterCustomViewAlertDialog filterCustomViewAlertDialog = Mockito.mock(FilterCustomViewAlertDialog.class);
        when(filterCustomViewAlertDialog.getLocationEditText()).thenReturn(null);
        assertEquals(false , filterCustomViewAlertDialog.isFieldsValid());
    }


}
