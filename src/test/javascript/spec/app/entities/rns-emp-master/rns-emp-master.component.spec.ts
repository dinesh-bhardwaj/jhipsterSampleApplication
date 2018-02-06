/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { JhipsterSampleApplicationTestModule } from '../../../test.module';
import { RNS_EMP_MASTERComponent } from '../../../../../../main/webapp/app/entities/rns-emp-master/rns-emp-master.component';
import { RNS_EMP_MASTERService } from '../../../../../../main/webapp/app/entities/rns-emp-master/rns-emp-master.service';
import { RNS_EMP_MASTER } from '../../../../../../main/webapp/app/entities/rns-emp-master/rns-emp-master.model';

describe('Component Tests', () => {

    describe('RNS_EMP_MASTER Management Component', () => {
        let comp: RNS_EMP_MASTERComponent;
        let fixture: ComponentFixture<RNS_EMP_MASTERComponent>;
        let service: RNS_EMP_MASTERService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [JhipsterSampleApplicationTestModule],
                declarations: [RNS_EMP_MASTERComponent],
                providers: [
                    RNS_EMP_MASTERService
                ]
            })
            .overrideTemplate(RNS_EMP_MASTERComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(RNS_EMP_MASTERComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(RNS_EMP_MASTERService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new RNS_EMP_MASTER(123)],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.rNS_EMP_MASTERS[0]).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
