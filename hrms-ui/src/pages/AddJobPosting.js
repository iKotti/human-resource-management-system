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
      jobPostingName: Yup.string().required("??lan ba??l?????? zorunludur."),
      description: Yup.string().required("A????klama  zorunludur."),
      numberOfOpenPosition: Yup.string().required("Eleman say??s?? giriniz."),
      jobPositionId: Yup.number().required("Bir pozisyon se??iniz."),
      cityId: Yup.number().required("Bir ??ehir se??iniz. "),
      workingPlaceTypeId: Yup.number().required("Bir ??al????ma yeri se??iniz."),
      workingTimeTypeId: Yup.number().required("Bir ??al????ma zaman?? se??iniz."),
      applicationDeadline: Yup.date().required("Son ba??vuru tarihi se??iniz."),
      maxSalary: Yup.number().required("Maksimum maa?? de??erini giriniz."),
      minSalary: Yup.number().required("Minimum maa?? de??erini giriniz."),
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
      <h2>???? ??lan?? Yay??nla </h2>
      <Form onSubmit={handleSubmit}>
        <Grid>
          <Grid.Row>
            <Grid.Column width="14">
              <Form.Input
                id="jobPostingName"
                type="text"
                label="??lan Ba??l??????"
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
                placeholder="Pozisyon Se??iniz"
                search
                selection
                error={touched.jobPositionId && errors.jobPositionId}
              ></Form.Select>

              <Form.Input
                id="applicationDeadline"
                type="date"
                label="Son Ba??vuru Tarihi"
                error={touched.applicationDeadline && errors.applicationDeadline }
                onChange={handleChange}
                onBlur={handleBlur}
                value={values.applicationDeadline}
              ></Form.Input>

              <Form.Input
                id="minSalary"
                type="number"
                placeholder="??rn: 3000"
                label="Minimum Maa??"
                value={values.minSalary}
                onChange={handleChange}
                error={touched.minSalary && errors.minSalary}
                onBlur={handleBlur}
              />
              <Form.Select
                id="workingTimeTypeId"
                label="??al????ma Zaman??"
                onChange={(event, data) =>
                  setFieldValue("workingTimeTypeId", data.value)
                }
                onBlur={onBlur}
                value={values.workingTimeTypeId}
                options={workingTimeTypeOptions}
                placeholder="??al????ma Zaman?? Se??iniz"
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
                label="??ehir"
                placeholder="??ehir Se??iniz"
                search
                selection
                error={touched.cityId && errors.cityId}
              ></Form.Select>

              <Form.Input
                id="numberOfOpenPosition"
                type="number"
                placeholder="??rn:1,2,3"
                label="Al??nacak Eleman Say??s??"
                onChange={handleChange}
                onBlur={handleBlur}
                error={touched.numberOfOpenPosition && errors.numberOfOpenPosition}
                value={values.numberOfOpenPosition}
              />
              <Form.Input
                id="maxSalary"
                type="number"
                placeholder="??rn: 5000"
                label="Maksimum Maa??"
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
                label="??al????ma Yeri"
                placeholder="??al????ma Yeri Se??iniz"
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
                placeholder="A????klama"
                label="A????klama"
                onChange={handleChange}
                onBlur={handleBlur}
                error={touched.description && errors.description }
                value={values.description}
              />
            </Grid.Column>
          </Grid.Row>
        </Grid>

        <Button primary type="submit" disabled={!dirty || isSubmitting} style={{ marginTop: "1.5em" }}>
          Yay??nla
        </Button>
      </Form>
    </Container>
  );
}
