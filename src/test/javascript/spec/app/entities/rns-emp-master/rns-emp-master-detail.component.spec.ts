/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { JhipsterSampleApplicationTestModule } from '../../../test.module';
import { RNS_EMP_MASTERDetailComponent } from '../../../../../../main/webapp/app/entities/rns-emp-master/rns-emp-master-detail.component';
import { RNS_EMP_MASTERService } from '../../../../../../main/webapp/app/entities/rns-emp-master/rns-emp-master.service';
import { RNS_EMP_MASTER } from '../../../../../../main/webapp/app/entities/rns-emp-master/rns-emp-master.model';

describe('Component Tests', () => {

    describe('RNS_EMP_MASTER Management Detail Component', () => {
        let comp: RNS_EMP_MASTERDetailComponent;
        let fixture: ComponentFixture<RNS_EMP_MASTERDetailComponent>;
        let service: RNS_EMP_MASTERService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [JhipsterSampleApplicationTestModule],
                declarations: [RNS_EMP_MASTERDetailComponent],
                providers: [
                    RNS_EMP_MASTERService
                ]
            })
            .overrideTemplate(RNS_EMP_MASTERDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(RNS_EMP_MASTERDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(RNS_EMP_MASTERService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                spyOn(service, 'find').and.returnValue(Observable.of(new HttpResponse({
                    body: new RNS_EMP_MASTER(123)
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.find).toHaveBeenCalledWith(123);
                expect(comp.rNS_EMP_MASTER).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
