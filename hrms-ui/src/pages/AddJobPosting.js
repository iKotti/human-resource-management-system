import React, { useState, useEffect } from "react";
import JobPositionService from "../services/JobPositionService";
import JobPostingService from "../services/JobPostingService";
import CityService from "../services/CityService";
import WorkingPlaceTypeService from "../services/WorkingPlaceTypeService";
import WorkingTimeTypeService from "../services/WorkingTimeTypeService";

import { Button, Container, Form, Grid } from "semantic-ui-react";
import { useFormik } from "formik";
import * as Yup from "yup";

export default function AddJobPosting() {
  let jobPostingService = new JobPostingService();

  const [jobPositions, setJobPositions] = useState([]);
  const [cities, setCities] = useState([]);
  const [workingPlaceTypes, setWorkingPlaceTypes] = useState([]);
  const [workingTimeTypes, setWorkingTimeTypes] = useState([]);

  useEffect(() => {
    let jobPositionService = new JobPositionService();
    jobPositionService
      .getJobPositions()
      .then((result) => setJobPositions(result.data));

    let cityService = new CityService();
    cityService.getCities().then((result) => setCities(result.data.data));

    let workingPlaceTypeService = new WorkingPlaceTypeService();
    workingPlaceTypeService
      .getWorkingPlaceTypes()
      .then((result) => setWorkingPlaceTypes(result.data.data));

    let workingTimeTypeService = new WorkingTimeTypeService();
    workingTimeTypeService
      .getWorkingTimeTypes()
      .then((result) => setWorkingTimeTypes(result.data.data));
  }, []);

  ///////////////////////////////////////////////

  const {
    values,
    errors,
    onBlur,
    setFieldValue,
    dirty,
    isSubmitting,
    handleSubmit,
    handleChange,
    handleBlur,
    touched
  } = useFormik({
    initialValues: {
      jobPostingName: "",
      description: "",
      numberOfOpenPosition: "",
      jobPositionId: "",
      cityId: "",
      workingPlaceTypeId: "",
      workingTimeTypeId: "",
      applicationDeadline: "",
      maxSalary: "",
      minSalary: "",
      employerId: 81,
    },

    onSubmit: (values,{resetForm,setSubmitting}) => {
      let jobPosting = {
        applicationDeadline: values.applicationDeadline,
        city: { cityId: values.cityId },
        description: values.description,
        employer: { id: values.employerId },
        jobPosition: { jobPositionId: values.jobPositionId },
        jobPostingName: values.jobPostingName,
        minSalary: values.minSalary,
        maxSalary: values.maxSalary,
        numberOfOpenPosition: values.numberOfOpenPosition,
        workingPlaceType: { workingPlaceTypeId: values.workingPlaceTypeId },
        workingTimeType: { workingTimeTypeId: values.workingTimeTypeId },
        isConfirm: false,
        activationStatus: true,
      };

      jobPostingService.add(jobPosting);
      setTimeout(()=>{
        resetForm();
        setSubmitting(false);
      },1000);
    },

    validationSchema: Yup.object({
      jobPostingName: Yup.string().required("İlan başlığı zorunludur."),
      description: Yup.string().required("Açıklama  zorunludur."),
      numberOfOpenPosition: Yup.string().required("Eleman sayısı giriniz."),
      jobPositionId: Yup.number().required("Bir pozisyon seçiniz."),
      cityId: Yup.number().required("Bir şehir seçiniz. "),
      workingPlaceTypeId: Yup.number().required("Bir çalışma yeri seçiniz."),
      workingTimeTypeId: Yup.number().required("Bir çalışma zamanı seçiniz."),
      applicationDeadline: Yup.date().required("Son başvuru tarihi seçiniz."),
      maxSalary: Yup.number().required("Maksimum maaş değerini giriniz."),
      minSalary: Yup.number().required("Minimum maaş değerini giriniz."),
    }),
  });

  //////////////////// OPTIONS //////////////////////////////

  const jobPositonOptions = jobPositions.map((jobPosition) => ({
    key: jobPosition.jobPositionId,
    text: jobPosition.title,
    value: jobPosition.jobPositionId,
  }));

  const cityOptions = cities.map((city) => ({
    key: city.cityId,
    text: city.cityName,
    value: city.cityId,
  }));

  const workingPlaceTypeOptions = workingPlaceTypes.map((workingPlaceType) => ({
    key: workingPlaceType.workingPlaceTypeId,
    text: workingPlaceType.workingPlaceName,
    value: workingPlaceType.workingPlaceTypeId,
  }));

  const workingTimeTypeOptions = workingTimeTypes.map((workingTimeType) => ({
    key: workingTimeType.workingTimeTypeId,
    text: workingTimeType.workingTimeName,
    value: workingTimeType.workingTimeTypeId,
  }));

  return (
    <Container>
      <h2>İş İlanı Yayınla </h2>
      <Form onSubmit={handleSubmit}>
        <Grid>
          <Grid.Row>
            <Grid.Column width="14">
              <Form.Input
                id="jobPostingName"
                type="text"
                label="İlan Başlığı"
                value={values.jobPostingName}
                error={touched.minSalary && errors.jobPostingName }
                onChange={handleChange}
              ></Form.Input>
            </Grid.Column>
          </Grid.Row>

          <Grid.Row>
            <Grid.Column width="7">
              <Form.Select
                id="jobPositionId"
                onChange={(fieldName, data) =>
                  setFieldValue("jobPositionId", data.value)
                }
                onBlur={onBlur}
                value={values.jobPositionId}
                options={jobPositonOptions}
                label="Pozisyon"
                placeholder="Pozisyon Seçiniz"
                search
                selection
                error={touched.jobPositionId && errors.jobPositionId}
              ></Form.Select>

              <Form.Input
                id="applicationDeadline"
                type="date"
                label="Son Başvuru Tarihi"
                error={touched.applicationDeadline && errors.applicationDeadline }
                onChange={handleChange}
                onBlur={handleBlur}
                value={values.applicationDeadline}
              ></Form.Input>

              <Form.Input
                id="minSalary"
                type="number"
                placeholder="Örn: 3000"
                label="Minimum Maaş"
                value={values.minSalary}
                onChange={handleChange}
                error={touched.minSalary && errors.minSalary}
                onBlur={handleBlur}
              />
              <Form.Select
                id="workingTimeTypeId"
                label="Çalışma Zamanı"
                onChange={(event, data) =>
                  setFieldValue("workingTimeTypeId", data.value)
                }
                onBlur={onBlur}
                value={values.workingTimeTypeId}
                options={workingTimeTypeOptions}
                placeholder="Çalışma Zamanı Seçiniz"
                search
                selection
                error={touched.workingTimeTypeId && errors.workingTimeTypeId}
              ></Form.Select>
            </Grid.Column>

            <Grid.Column width="7">
              <Form.Select
                id="cityId"
                onBlur={onBlur}
                value={values.cityId}
                options={cityOptions}
                onChange={(event, data) => setFieldValue("cityId", data.value)}
                label="Şehir"
                placeholder="Şehir Seçiniz"
                search
                selection
                error={touched.cityId && errors.cityId}
              ></Form.Select>

              <Form.Input
                id="numberOfOpenPosition"
                type="number"
                placeholder="Örn:1,2,3"
                label="Alınacak Eleman Sayısı"
                onChange={handleChange}
                onBlur={handleBlur}
                error={touched.numberOfOpenPosition && errors.numberOfOpenPosition}
                value={values.numberOfOpenPosition}
              />
              <Form.Input
                id="maxSalary"
                type="number"
                placeholder="Örn: 5000"
                label="Maksimum Maaş"
                onChange={handleChange}
                onBlur={handleBlur}
                error={ touched.maxSalary && errors.maxSalary}
                value={values.maxSalary}
              />
              <Form.Select
                id="workingPlaceTypeId"
                onChange={(event, data) =>
                  setFieldValue("workingPlaceTypeId", data.value)
                }
                onBlur={onBlur}
                value={values.workingPlaceTypeId}
                options={workingPlaceTypeOptions}
                label="Çalışma Yeri"
                placeholder="Çalışma Yeri Seçiniz"
                search
                selection
                error={touched.workingTimeTypeId && errors.workingPlaceTypeId}
              ></Form.Select>
            </Grid.Column>
          </Grid.Row>
          <Grid.Row>
            <Grid.Column width="14">
              <Form.TextArea
                id="description"
                type="text"
                placeholder="Açıklama"
                label="Açıklama"
                onChange={handleChange}
                onBlur={handleBlur}
                error={touched.description && errors.description }
                value={values.description}
              />
            </Grid.Column>
          </Grid.Row>
        </Grid>

        <Button primary type="submit" disabled={!dirty || isSubmitting} style={{ marginTop: "1.5em" }}>
          Yayınla
        </Button>
      </Form>
    </Container>
  );
}
